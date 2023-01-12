package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "headquarter_tb")
public class HeadQuarter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "headQuarter")
	private Address address;
	
	@OneToMany(mappedBy = "headQuarter")
	private List<Car> cars = new ArrayList<>();
	
	@OneToMany(mappedBy = "headQuarter")
	private List<Rent> rent = new ArrayList<>();
	
	
	
	public HeadQuarter() {
		
	}

	public HeadQuarter(Integer code, Address address) {
		super();
		this.code = code;
		this.address = address;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Rent> getRent() {
		return rent;
	}

	public void setRent(List<Rent> rent) {
		this.rent = rent;
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
