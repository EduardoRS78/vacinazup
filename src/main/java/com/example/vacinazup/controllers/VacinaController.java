package com.example.vacinazup.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.vacinazup.models.Vacina;
import com.example.vacinazup.models.Vacinado;
import com.example.vacinazup.repository.VacinaRepository;
import com.example.vacinazup.repository.VacinadoRepository;



@Controller
public class VacinaController {
	
	@Autowired
	private VacinaRepository er;
	
	@Autowired
	private VacinadoRepository vr;
	
	@RequestMapping(value ="/CadastraVacina", method=RequestMethod.GET)
	public String form(){
		return "vacina/formVacina";
	}

	@RequestMapping(value ="/CadastraVacina", method=RequestMethod.POST)
	public String form(@Valid Vacina vacina,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", 201);
			return "vacina/formVacina";
		}
		er.save(vacina);
		
		return "vacina/formVacina";
	}
	
	@RequestMapping("/vacinas")
	public ModelAndView listaVacinas(){
		ModelAndView mv = new ModelAndView("listaDeVacina");
		Iterable<Vacina> vacina = er.findAll();
		mv.addObject("vacina", vacina);
		
		return mv;
	}
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesVacina(@PathVariable("codigo") long codigo){
        Vacina vacina = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("detalhesVacina");
        mv.addObject("vacina", vacina);
        Iterable<Vacinado> vacinado = vr.findByVacina(vacina);
        mv.addObject("vacinado", vacinado);
        return mv;
    }
	
	@RequestMapping("/deletarVacina")
	public String deletarVacina(long codigo){
		Vacina vacina = er.findByCodigo(codigo);
		er.delete(vacina);
		return "listaDeVacina";
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalhesVacinaPost(@PathVariable("codigo") long codigo, @Valid Vacinado vacinado,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", 400);
			return "listaDeVacina";
		}
        Vacina vacina = er.findByCodigo(codigo);
        vacinado.setVacina(vacina);
        vr.save(vacinado);
        attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
        return "listaDeVacina";
    }
	
	
	@RequestMapping("/deletarVacinado")
	public String deletarVacinado(Long cod){
		Vacinado vacinado = vr.findByCod(cod);
		vr.delete(vacinado);
		return "detalhesVacina";
		
	}


	 
}
