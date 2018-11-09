package com.cispal.miPrimeraApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/example2")
public class Example2Controller {
	
	private static final String VISTA="example2";
	
	
	//primera forma: localhost:8080/request1?name=jhon
	//primera forma: localhost:8080/request1?name=jhon
	@GetMapping("/request1")
	public ModelAndView request(@RequestParam(name="name",required=false,defaultValue="NULL") String name) {
		ModelAndView model = new ModelAndView(VISTA);
		model.addObject("name_in_model",name);
		return model;
	}

}
