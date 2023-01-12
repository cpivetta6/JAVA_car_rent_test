package com.caiopivetta6.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentDaily_tb")
public class RentDaily extends Rent{


	private static final long serialVersionUID = 1L;
	
	private Integer days;
	
	public RentDaily() {
		
	}

	public RentDaily(Integer id, Date dateRent, Date dateDevolution, Integer days) {
		super(id, dateRent, dateDevolution);
		this.days = days;
		
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	
	
	
	
	
	
}
