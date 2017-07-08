package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.PaymentType;
import com.example.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	@Override
	public List<PaymentType> listPaymentTypes() {
		return paymentTypeRepository.findAll();
	}
	
}
