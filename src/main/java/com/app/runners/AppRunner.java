package com.app.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.entites.Cities;
import com.app.entites.Countries;
import com.app.entites.States;
import com.app.repositories.CitiesRepository;
import com.app.repositories.CountryRepository;
import com.app.repositories.StatesRepository;

@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	private CountryRepository countriesRepo;
	@Autowired
	private StatesRepository statesRepo;
	@Autowired
	private CitiesRepository citiesRepo;

	@Override
	public void run(String... args) throws Exception {
		
		countriesRepo.deleteAll();
		statesRepo.deleteAll();
		citiesRepo.deleteAll();
		Countries country1 = new Countries(1,"India");
		Countries country2 = new Countries(2,"USA");
		Countries country3 = new Countries(3,"Canada");
		
		countriesRepo.saveAll(Arrays.asList(country1,country2,country3));
		
		States s1 = new States(1,"AP",country1);
		States s2 = new States(2,"Telengana",country1);
		
		States s3 = new States(3,"New York",country2);
		States s4 = new States(4,"Colorado",country2);
		States s5 = new States(5,"Texas",country3);
		
		States s6 = new States(6,"Alberta",country3);
		States s7 = new States(7,"Quebec",country3);
		States s8 = new States(8,"Manitoba",country3);
		
		statesRepo.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8));
		
		Cities c1 = new Cities(1,"Jaggampeta",s1);
		Cities c2 = new Cities(2,"Kakinada",s1);

		Cities c3 = new Cities(3,"Hyderabad",s2);
		Cities c4 = new Cities(4,"Khammam,",s2);
		
		
		Cities c5 = new Cities(5,"New York city",s3);
		Cities c6 = new Cities(6,"Albany",s3);
		
		
		Cities c7 = new Cities(7,"San Antonio",s5);
		Cities c8 = new Cities(8,"Dallas",s5);

		Cities c9 = new Cities(9,"Denver",s4);
		Cities c10 = new Cities(10,"Aurora",s4);

		Cities c11= new Cities(11,"Lonon",s6);
		Cities c12= new Cities(12,"Manchester",s6);
		
		Cities c13= new Cities(13,"LiverPool",s7);
		Cities c14= new Cities(14,"Leeds",s7);
		
		Cities c15= new Cities(15,"Oxford",s8);
		Cities c16= new Cities(16,"Nottingham",s8);
		
		citiesRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16));

		

	}

}
