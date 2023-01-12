package com.caiopivetta6;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Client;
import com.caiopivetta6.repositories.ClientRepository;

@SpringBootApplication
public class CarRentProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarRentProjectApplication.class, args);
	}
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Client client1 = new Client(null, "Robert Lewis", "robert@gmail.com");
		client1.getPhone().add("39213123142");
		
		clientRepository.saveAll(Arrays.asList(client1));
		
		
		
	}

	
	
}
