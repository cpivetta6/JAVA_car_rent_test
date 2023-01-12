package com.caiopivetta6.domain;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentLongTerm_tb")
public class RentLongTerm extends Rent{


	private Integer days;
	
	public RentLongTerm() {
		
	}

	public RentLongTerm(Integer id, Instant dateRent, Instant dateDevolution, Client client, Car car,HeadQuarter headQuarter, Integer days) {
		super(id, dateRent, dateDevolution, client, car, headQuarter);
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
