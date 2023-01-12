package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.domain.HeadQuarter;
import com.caiopivetta6.service.HeadQuarterService;

@RestController
@RequestMapping(value = "/headquarter")
public class HeadQuarterResource {
	
	@Autowired
	private HeadQuarterService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HeadQuarter> findById (@PathVariable Integer id) {
		
		HeadQuarter obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}


