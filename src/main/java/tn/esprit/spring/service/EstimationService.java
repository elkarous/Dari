package tn.esprit.spring.service;

import java.util.Map;

import tn.esprit.spring.dto.HouseDto;

public interface EstimationService {
	public Map<String, Float> estimation(HouseDto house);
}
