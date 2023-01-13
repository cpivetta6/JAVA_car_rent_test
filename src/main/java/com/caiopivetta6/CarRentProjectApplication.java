package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.Car;
import com.caiopivetta6.domain.Category;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.HeadQuarter;
import com.caiopivetta6.domain.Rent;
import com.caiopivetta6.domain.RentDaily;
import com.caiopivetta6.domain.RentLongTerm;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CarRepository;
import com.caiopivetta6.repositories.CategoryRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.ClientRepository;
import com.caiopivetta6.repositories.HeadQuarterRepository;
import com.caiopivetta6.repositories.RentRepository;
import com.caiopivetta6.repositories.StateRepository;

@SpringBootApplication
public class CarRentProjectApplication implements CommandLineRunner {

	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private HeadQuarterRepository headQuarterRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CarRentProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:ss");
		
		//CITY AND STATE
		
		State state1 = new State(null, "Piemonte");
		State state2 = new State(null, "Veneto");
				
		City city1 = new City(null, "Torino", state1);
		City city2 = new City(null, "Verona", state2);
				
		state1.getCity().addAll(Arrays.asList(city1));
		state2.getCity().addAll(Arrays.asList(city2));
				
		stateRepository.saveAll(Arrays.asList(state1,state2));
		cityRepository.saveAll(Arrays.asList(city1,city2));
		
		
		//ADDRESS AND HEADQUARTERS
		
		
		Address address1 = new Address(null, "Regina Adelaide","Borgo Roma", "45","1752032", city2);
		Address address2 = new Address(null, "Mazini Lazeroni","Borgo Luna", "43","2342032", city1);
				
		HeadQuarter hq1 = new HeadQuarter(null);
		HeadQuarter hq2 = new HeadQuarter(null);
				
		hq1.setAddress(address1);
		hq2.setAddress(address2);
				
		address1.setHeadQuarter(hq1);
		address2.setHeadQuarter(hq2);
				
				
		headQuarterRepository.saveAll(Arrays.asList(hq1,hq2));
		addressRepository.saveAll(Arrays.asList(address1,address2));
		
		//CAR AND CATEGORY
		
		
		Category category1 = new Category(null, "Luxury Car", 80.0);
		Category category2 = new Category(null, "Sportive Car", 200.0);
		
		Car car1 = new Car(null, "Jeep", "DN320XF",2022, "black");
		Car car2 = new Car(null, "Alpha Romeo", "FG123AS", 2023, "red");
		
		
		//category get cars
		
		hq1.getCars().addAll(Arrays.asList(car1));
		hq2.getCars().addAll(Arrays.asList(car1,car2));
		
		
		category1.getCars().addAll(Arrays.asList(car1, car2));
		category2.getCars().addAll(Arrays.asList(car2));
		
		car1.setHeadQuarter(hq2);
		car2.setHeadQuarter(hq1);
		
		car1.setCategory(category2);
		car2.setCategory(category1);
		
		categoryRepository.saveAll(Arrays.asList(category1,category2));
		carRepository.saveAll(Arrays.asList(car1,car2));
		
		
		
		//CLIENT AND RENT
		
		
		Client client1 = new Client(null, "Robert Lewis", "robert@gmail.com");
		client1.getPhone().add("39213123142");
		
		
		Rent rent1 = new RentDaily(null, sdf.parse("22/01/2023 10:30").toInstant(), sdf.parse("24/01/2023 10:30").toInstant(), client1, car1, hq1);
		Rent rent2 = new RentLongTerm(null, sdf.parse("22/01/2023 10:30").toInstant(), sdf.parse("22/01/2023 10:30").toInstant(), client1, car2, hq2, 2);
		Rent rent3 = new RentLongTerm(null, sdf.parse("22/01/2023 10:30").toInstant(), sdf.parse("22/01/2023 10:30").toInstant(), client1, car2, hq2, 2);
		
		//car get rent
		car1.getRent().addAll(Arrays.asList(rent1));
		car2.getRent().addAll(Arrays.asList(rent3));
		
		//headquarter get rents
		hq1.getRent().addAll(Arrays.asList(rent1));
		hq2.getRent().addAll(Arrays.asList(rent1));
		
		client1.getRent().addAll(Arrays.asList(rent1,rent2,rent3));
		
		
		clientRepository.saveAll(Arrays.asList(client1));
		rentRepository.saveAll(Arrays.asList(rent1, rent2));
		
		
		
	}

	
	
}
