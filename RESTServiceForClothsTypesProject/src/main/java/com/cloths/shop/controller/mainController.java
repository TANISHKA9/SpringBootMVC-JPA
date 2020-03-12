package com.cloths.shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloths.shop.model.ClothsType;

@RestController("/cloths")
public class mainController {

	@Autowired
	private ClothsType clothsType;
	
	ConcurrentMap<Integer, ClothsType> concurrentMap = new ConcurrentHashMap<>();
	
	@GetMapping("/getAllClothsType")
	public List<ClothsType> getAllClothsType()
	{
		return new ArrayList<ClothsType>(concurrentMap.values());
	}
	
	@GetMapping("/getClothsType/{id}")
	public ClothsType getClothsTypeById(@PathVariable int id)
	{
		return concurrentMap.get(id);
	}
	
	@PostMapping("/SetClothsType")
	public ClothsType setClothsType(@RequestBody ClothsType clothsType)
	{
		concurrentMap.put(clothsType.getId(), clothsType);
		return clothsType;
	}
	
}
