package com.example.domain;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("BEVERAGE")
public class Beverage extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(name="BEVERAGE_ADDITION_MAP",joinColumns=@JoinColumn(name="BEVERAGE_ID",referencedColumnName="ID"),inverseJoinColumns=@JoinColumn(name="ADDITION_ID",referencedColumnName="ID"))
	Set<Addition> additions;

	public Set<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(Set<Addition> additions) {
		this.additions = additions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
