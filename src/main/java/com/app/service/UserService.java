package com.app.service;

import java.util.Map;

import com.app.entites.User_master;
import com.appbindings.LoginFormBinding;
import com.appbindings.RegisterFormBinding;
import com.appbindings.UpdatePasswordBinding;

public interface UserService {
	
	public Map<Integer,String> getCountries();
	public Map<Integer , String >getStates(Integer countryId);
	public Map<Integer , String >getCities(Integer stateId);
	public boolean register(RegisterFormBinding form);
	public User_master login(LoginFormBinding form);
	public boolean checkUser(String email);
	boolean updatePassword(UpdatePasswordBinding form);
}
