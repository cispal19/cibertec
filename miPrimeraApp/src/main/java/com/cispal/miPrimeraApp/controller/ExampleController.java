package com.cispal.miPrimeraApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cispal.miPrimeraApp.model.Persona;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String VISTA_EXAMPLE ="example";
	
	// primera forma

	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String primeraforma(Model model) {
		model.addAttribute("personas", getPersonas());
		return VISTA_EXAMPLE;
	}
	
	//SEGUND AFORMA
	@RequestMapping(value="/exampleMv", method=RequestMethod.GET)
	public ModelAndView holaMundo() {
		ModelAndView model = new ModelAndView(VISTA_EXAMPLE);
		model.addObject("personas",getPersonas());
		return model;
	}
	
	
	public List<Persona> getPersonas(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("juan", 15));
		personas.add(new Persona("jose", 15));
		personas.add(new Persona("maria", 15));
		personas.add(new Persona("rosa", 15));
		
		return personas;
	}
	
	
}
