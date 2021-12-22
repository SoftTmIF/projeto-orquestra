package br.iftm.edu.orquestrademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControlador {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/")
	public String begin() {
		return "redirect:/login";
	}

}

