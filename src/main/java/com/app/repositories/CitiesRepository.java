package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Cities;
import com.app.entites.States;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {

      List<Cities> findByStateId(States states);

	

}
