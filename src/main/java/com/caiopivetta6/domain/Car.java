package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_tb")
public class Car implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String model;
	private String licensePlate;
	private String color;
	private Integer yearOf;
	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "headQuarter_id")
	private HeadQuarter headQuarter;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Lob
	@JsonIgnore
	@OneToMany(mappedBy = "car")
	private List<Rent> rent = new ArrayList<>();
	
	public Car () {
		
	}

	public Car(Integer id, String model, String licensePlate,Integer yearOf, String color ) {
		super();
		this.id = id;
		this.model = model;
		this.licensePlate = licensePlate;
		this.yearOf = yearOf;
		this.color = color;
		
	}

	

	public Integer getYearOf() {
		return yearOf;
	}

	public void setYearOf(Integer yearOf) {
		this.yearOf = yearOf;
	}

	public HeadQuarter getHeadQuarter() {
		return headQuarter;
	}

	public void setHeadQuarter(HeadQuarter headQuarter) {
		this.headQuarter = headQuarter;
	}

	public List<Rent> getRent() {
		return rent;
	}

	public void setRent(List<Rent> rent) {
		this.rent = rent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		Car other = (Car) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
