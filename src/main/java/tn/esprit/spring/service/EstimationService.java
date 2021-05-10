package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.dto.UnitPriceDto;
import tn.esprit.spring.entities.UnitPrice;

public interface EstimationService {
	public Map<String, Float> estimation(HouseDto house);

	public UnitPriceDto addUnitPrice(UnitPriceDto unitPriceDto);

	public void deleteUnitPrice(Long id);

	public UnitPriceDto updateUnitPrice(UnitPriceDto unitPriceDto);

	public List<UnitPriceDto> getAll();

	public UnitPrice getUnitpriceByMunicipal(String municipale);
}
