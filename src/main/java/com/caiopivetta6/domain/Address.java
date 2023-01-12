package com.caiopivetta6.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String publicPlace;
	private String square;
	private String number;
	private String zcode;
	
	public Address() {
		
	}

	public Address(Integer id, String publicPlace, String square, String number, String zcode) {
		super();
		this.id = id;
		this.publicPlace = publicPlace;
		this.square = square;
		this.number = number;
		this.zcode = zcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZcode() {
		return zcode;
	}

	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
