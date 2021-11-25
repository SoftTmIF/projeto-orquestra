package br.iftm.edu.orquestrademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iftm.edu.orquestrademo.model.Usuario;
import br.iftm.edu.orquestrademo.repository.UsuarioRepository;

@Controller
public class HomeControlador {

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}

	@PostMapping("/home-mock")
	public String homeMock() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}

}

