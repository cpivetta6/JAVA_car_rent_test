package com.caiopivetta6.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentLongTerm_tb")
public class RentLongTerm extends Rent{

	
	private static final long serialVersionUID = 1L;

	private Integer days;
	
	public RentLongTerm() {
		
	}

	public RentLongTerm(Integer id, Date dateRent, Date dateDevolution, Integer days) {
		super(id, dateRent, dateDevolution);
		this.days = days;
		// TODO Auto-generated constructor stub
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	
	
	
	
	
}
