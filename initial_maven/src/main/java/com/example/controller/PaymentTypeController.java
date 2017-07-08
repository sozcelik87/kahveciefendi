package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.PaymentType;
import com.example.service.PaymentTypeService;

@RestController
@RequestMapping("/api/v1/paymentType")
public class PaymentTypeController {
	
	@Autowired
	private PaymentTypeService paymentTypeService;

    @RequestMapping(value="/list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentType> listPaymentTypes() {
    	return paymentTypeService.listPaymentTypes();
    }
}