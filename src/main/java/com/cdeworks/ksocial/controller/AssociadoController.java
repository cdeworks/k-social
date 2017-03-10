package com.cdeworks.ksocial.controller;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdeworks.ksocial.repository.model.Associado;

@Controller
@RequestMapping("/associado")
public class AssociadoController {
	
	
	@GetMapping
	public ModelAndView form(Associado associado) {
		ModelAndView mav = new ModelAndView("/associados/associado");
		
		return mav;
		
	}
	
	@PostMapping
	public String salvar() {
		System.out.println("Salvando Associado");
		return null;
	}

}
