package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "headquarter_tb")
public class HeadQuarter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	/*
	
	private Address address = new Address();
	
	private List<Car> cars = new ArrayList<>();
	
	private List<Rent> rent = new ArrayList<>();
	*/
	
	
	public HeadQuarter() {
		
	}

	public HeadQuarter(Integer code) {
		super();
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeadQuarter other = (HeadQuarter) obj;
		return Objects.equals(code, other.code);
	}
	
	
	
}
