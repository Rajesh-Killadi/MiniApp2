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
public class Cities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	private String cityName;
	@ManyToOne
	@JoinColumn(name = "stateId",referencedColumnName = "stateId")
	private States stateId;
	public Cities(Integer cityId, String cityName, States stateId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateId = stateId;
	}
	public Cities() {
		super();
	}
	

	
}
