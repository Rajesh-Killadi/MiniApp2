package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.service.DashboardService;
import com.appbindings.DashboardBinding;
import com.appbindings.LoginFormBinding;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping(value = "/dashboard")
	public String buildDashboardPage(Model model) {

		DashboardBinding dashboardQuote = dashboardService.generateQuote();

		model.addAttribute("dashboardBinding", dashboardQuote);

		return "dashboard";

	}
	@GetMapping(value="/logout")
	public String logout(Model model , HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		model.addAttribute("loginBinding", new LoginFormBinding());
		return "redirect:/";
		
		
	}
}
