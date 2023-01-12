package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Instant d1 = sdf.parse("22/02/2222").toInstant();
		
		int n = d1.atZone(ZoneId.systemDefault()).getDayOfMonth();
		
		System.out.println(n);
		
	
		
	}

}
