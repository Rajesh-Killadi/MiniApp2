package com.app.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Countries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryId;
	private String countryName;
	public Countries(Integer countryId, String countryName) {
	
		this.countryId = countryId;
		this.countryName = countryName;
	}
	public Countries() {
		super();
	}
	

	

}
