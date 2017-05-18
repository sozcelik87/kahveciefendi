package com.example.service;

import java.util.List;

import com.example.domain.Addition;

public interface AdditionService {
	
	public List<Addition> getAdditionsByIdList(List<Long> ids);
}
