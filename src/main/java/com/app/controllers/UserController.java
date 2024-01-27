package com.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entites.User_master;
import com.app.service.DashboardService;
import com.app.service.UserService;
import com.appbindings.CountryBinding;
import com.appbindings.LoginFormBinding;
import com.appbindings.RegisterFormBinding;
import com.appbindings.StateBinding;
import com.appbindings.UpdatePasswordBinding;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DashboardService dashboardService;

	@GetMapping(value = "/")
	public String loginPage(Model model) {

		model.addAttribute("loginBinding", new LoginFormBinding());

		return "login";

	}

	@GetMapping(value = "/register")
	public String registerPage(Model model) {

		model.addAttribute("registerBinding", new RegisterFormBinding());
		
		model.addAttribute("countriesMap" , userService.getCountries());

		return "register";

	}

	@GetMapping(value = "/updatePassword")
	public String pwdUpdatePage(Model model) {

		model.addAttribute("updatePasswordBinding", new UpdatePasswordBinding());

		return "updatePassword";
	}

	

	@PostMapping(value = "/register")
	public String Register(Model model, @ModelAttribute("registerBinding")RegisterFormBinding form) {

		boolean checkUser = userService.checkUser(form.getEmail());
		if (checkUser) {
			model.addAttribute("registerResponse", "Email is Already Registred");
			return "register";
		}

		boolean register = userService.register(form);

		if (register) {
			model.addAttribute("registerResponseSuccess", "Check your Email for Password");
		} else {
			model.addAttribute("registerResponse", "Registration Failed");
		}

		model.addAttribute("countriesMap" , userService.getCountries());
		
		return "register";

	}

	@PostMapping(value = "/login")
	public String login(@ModelAttribute("loginBinding")LoginFormBinding form,Model model , HttpServletRequest req) {

			User_master login = userService.login(form);
			if (login != null) {

				HttpSession session = req.getSession(true);
				session.setAttribute("userId", login.getUserId());

				if (login.getPasswordUpdated().equals("no")) {

					return "redirect:updatePassword";

				} else {
					return "redirect:dashboard";
				}
			} else {
				model.addAttribute("loginResponse","Invalid Credentials");
			}

		

	
		return "login";

	}

	@PostMapping(value = "/updatePassword")
	public String updatePassword(UpdatePasswordBinding form, Model model, HttpServletRequest req) {

		HttpSession session = req.getSession(false);

		form.setUserId((Integer) session.getAttribute("userId"));

		boolean updatePassword = userService.updatePassword(form);

		if (updatePassword) {

			return "redirect:dashboard";
		}
		model.addAttribute("updatePwdResponse", "Passwords does not match");
		return "updatePassword";
	}

	@PostMapping(value="getCountries")
	@ResponseBody
	public Map<Integer, String> getCountries() {

		return userService.getCountries();
	}
	
	@PostMapping(value="getStates")
	@ResponseBody
	public Map<Integer, String> getStates(@RequestBody CountryBinding binding) {
		System.out.println(binding);

		return userService.getStates(binding.getCountryId());
	}
	
	@PostMapping(value="getCities")
	@ResponseBody
	public Map<Integer, String> getCities(@RequestBody StateBinding binding) {
		System.out.println(binding);

		return userService.getCities(binding.getStateId());
	}

}
