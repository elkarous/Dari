package tn.esprit.spring.service;

import java.util.Map;

import tn.esprit.spring.dto.HouseDto;
import tn.esprit.spring.dto.UnitPriceDto;

public interface EstimationService {
	public Map<String, Float> estimation(HouseDto house);

	public UnitPriceDto addUnitPrice(UnitPriceDto unitPriceDto);

	public void deleteUnitPrice(Long id);

	public UnitPriceDto updateUnitPrice(UnitPriceDto unitPriceDto);
}
