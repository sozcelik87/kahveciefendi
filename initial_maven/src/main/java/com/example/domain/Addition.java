package com.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADDITION")
public class Addition extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
