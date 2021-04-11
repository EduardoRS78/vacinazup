package com.example.vacinazup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.vacinazup.models.Vacina;
import com.example.vacinazup.repository.VacinaRepository;

@Controller
public class VacinaController {
	
	@Autowired
	private VacinaRepository er;
	
	@RequestMapping(value ="/CadastraVacina", method=RequestMethod.GET)
	public String form(){
		return "vacina/formVacina";
	}

	@RequestMapping(value ="/CadastraVacina", method=RequestMethod.POST)
	public String form(Vacina vacina){
		er.save(vacina);
		
		return "redirect:/CadastraVacina";
	}
	
	@RequestMapping("/vacinas")
	public ModelAndView listaVacinas(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Vacina> vacinas = er.findAll();
		mv.addObject("vacinas", vacinas);
		return mv;
	}
}
