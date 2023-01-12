package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Rent implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant dateRent;
	private Instant dateDevolution;
	
	@ManyToOne
	@JoinColumn(name = "headQuarter")
	private HeadQuarter headQuarter = new HeadQuarter();
	
	@ManyToOne
	@JoinColumn (name = "car")
	private Car car = new Car();
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client = new Client();
	
	
	
	public Rent() {
		
	}

	public Rent(Integer id, Instant dateRent, Instant dateDevolution, Client client, Car car, HeadQuarter headQuarter) {
		super();
		this.id = id;
		this.dateRent = dateRent;
		this.dateDevolution = dateDevolution;
		this.client = client;
		this.car = car;
		this.headQuarter = headQuarter;
	}
	
	

	public HeadQuarter getHeadQuarter() {
		return headQuarter;
	}

	public void setHeadQuarter(HeadQuarter headQuarter) {
		this.headQuarter = headQuarter;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDateRent() {
		return dateRent;
	}

	public void setDateRent(Instant dateRent) {
		this.dateRent = dateRent;
	}

	public Instant getDateDevolution() {
		return dateDevolution;
	}

	public void setDateDevolution(Instant dateDevolution) {
		this.dateDevolution = dateDevolution;
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
		Rent other = (Rent) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
