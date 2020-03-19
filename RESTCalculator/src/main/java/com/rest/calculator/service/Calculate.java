package com.rest.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class Calculate{
	public int addition(int num1, int num2)
	{
		return num1+num2;
	}
	
	public int subtraction(int num1, int num2)
	{
		if(num1<num2)
			return num2-num1;
		else
			return num1-num2; 
	}
}
