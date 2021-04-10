package com.example.vacinazup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacinaController {
	
	@RequestMapping("/CadastraVacina")
	public String form(){
		return "vacina/formVacina";
	}


}
