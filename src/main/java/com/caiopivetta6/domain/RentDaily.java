package com.caiopivetta6.domain;

import java.time.Instant;
import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentDaily_tb")
public class RentDaily extends Rent{

	
	private Integer days;
	
	public RentDaily() {
		
	}

	public RentDaily(Integer id, Instant dateRent, Instant dateDevolution, Client client, Car car, HeadQuarter headQuarter) {
		super(id, dateRent, dateDevolution, client, car, headQuarter);
		this.days = daysRent(dateRent, dateDevolution);
	}
	
	private Integer daysRent(Instant d1, Instant d2) {
		
		int days = d2.atZone(ZoneId.systemDefault()).getDayOfMonth() - d1.atZone(ZoneId.systemDefault()).getDayOfMonth();
		
		return days;
		
		
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	
	
	
	
	
	
}
