package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Addition;
import com.example.repository.AdditionRepository;

@Service
public class AdditionServiceImpl implements AdditionService {

	@Autowired
	private AdditionRepository additionRepository;

	@Override
	public List<Addition> getAdditionsByIdList(List<Long> ids) {
		// TODO Auto-generated method stub
		return additionRepository.findAll(ids);
	}

}
