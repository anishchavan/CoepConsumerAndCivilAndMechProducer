package com.cjc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
	@Autowired
	RestTemplate rt;
	@GetMapping("/getcondata")
	public List<List> getAllData(){
		List list = new ArrayList<>();
		String url1 = "http://localhost:9092/getprodata";
		List list1 = rt.getForObject(url1, List.class);
		String url2 = "http://localhost:9091/getprodata";
		List list2 = rt.getForObject(url2, List.class);
		
		list.add(list1);
		list.add(list2);
		
		return list;
	}
	
	@GetMapping("/getconspecificdata/{nacgrade}/{noofstudents}")
	public List<List> getSpecificData(@PathVariable String nacgrade, @PathVariable int noofstudents) {
		List list = new ArrayList<>();
//		String url1 = "http://localhost:9092/getprospecificdata/'" + nacgrade + "'/'" + noofstudents + "'";
		String url1 = "http://localhost:9092/getprospecificdata/" + nacgrade + "/" + noofstudents;
		List list1 = rt.getForObject(url1, List.class);
//		String url2 = "http://localhost:9091/getprospecificdata/'" + nacgrade + "'/'" + noofstudents + "'";
		String url2 = "http://localhost:9091/getprospecificdata/" + nacgrade + "/" + noofstudents;
		List list2 = rt.getForObject(url2, List.class);
		list.add(list1);
		list.add(list2);
		
		return list;
		
	}
	
}
