package com.app.entites;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Entity
@Data
public class User_master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String phno;
	private String country;
	private String state;
	private String city;
	@CreationTimestamp
  //  @Temporal(TemporalType.DATE) // Use TemporalType.DATE to store only the date without time
    @Column(updatable = false)
	private LocalDateTime creationDate;
	@UpdateTimestamp
//	@Temporal(TemporalType.DATE)
	private LocalDateTime updatedDate;
	private String passwordUpdated;
	
}
