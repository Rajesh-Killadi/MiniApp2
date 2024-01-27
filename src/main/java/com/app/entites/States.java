package com.app.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;
	private String stateName;
	@ManyToOne
	@JoinColumn(name="countryId",referencedColumnName="countryId")
	private Countries countryId;
	public States(Integer stateId, String stateName, Countries countryId) {

		this.stateId = stateId;
		this.stateName = stateName;
		this.countryId = countryId;
	}
	public States() {
		super();
	}
	
	
	       
}
