package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.User_master;

public interface UsersRepository extends JpaRepository<User_master, Integer> {

	User_master findByEmailAndPassword(String email, String password);

	User_master findByEmail(String email);

}
