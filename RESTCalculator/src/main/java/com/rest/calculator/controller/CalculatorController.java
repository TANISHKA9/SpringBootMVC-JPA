package com.rest.calculator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.calculator.controller.model.Response;
import com.rest.calculator.service.Calculate;

@RestController
public class CalculatorController {
	
	@Autowired
	Calculate calculate;
	
	@PostMapping("/number")
	public Response number(@RequestParam int number1, @RequestParam int number2,
			HttpSession httpSession)
	{
		Response response = new Response();
		if(((String) httpSession.getAttribute("operation")).equalsIgnoreCase("addition"))
		{
			response.setNumber(calculate.addition(number1, number2));
		}
		
		if(((String) httpSession.getAttribute("operation")).equalsIgnoreCase("subtraction"))
		{
			response.setNumber(calculate.subtraction(number1, number2));
		}
		return response;
		
	}
	
	@GetMapping("/addition")
	public String addition(HttpSession httpSession)
	{
		httpSession.setAttribute("operation", "addition");
		return "redirect:/number";
		
	}
	
	@GetMapping("/subtraction")
	public String subtraction(HttpSession httpSession)
	{
		httpSession.setAttribute("operation", "subtraction");
		return "redirect:/number";
		
	}
}
