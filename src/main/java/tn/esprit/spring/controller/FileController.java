package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.repository.BankRepository;
import tn.esprit.spring.service.FileStorageService;
import tn.esprit.spring.shered.ResponseFile;



@Controller
@CrossOrigin("*")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  @Autowired
  BankRepository bankRipository ;
  
  @PostMapping("/upload")
  public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
   
      storageService.store(file);



  }
  @PostMapping("/upload/{bankId}")
  public void uploadFiletoBank(@RequestParam("file") MultipartFile file,@PathVariable("bankId") Long bankId ) throws IOException {
  
      storageService.store(file);
    Bank bank=  bankRipository.findById(bankId).get();
    bank.setLogo(storageService.store(file));
    bankRipository.save(bank);
    
    
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId() )
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }
 
  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable long id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  
}