package br.iftm.edu.orquestrademo.controller;

import br.iftm.edu.orquestrademo.model.Usuario;
import br.iftm.edu.orquestrademo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioRepository repository;

    //Criar novo usuário
    @GetMapping(value = "/novo-usuario")
	public String requestUsuario(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "novo-usuario";
	}

	@PostMapping(value = "/novo-usuario")
	public String novoUsuario(Usuario usuario) {
		if (repository.registraUsuario(usuario)) {
			return "redirect:/login";
		} else {
			return "redirect:/novo-usuario";
		}
	}

	//Autenticar usuário
	@GetMapping(value = "/login")
	public String requestLogin(Model modelo) {
		modelo.addAttribute("testeLogin", new Usuario());
		return "login";
	}
	@PostMapping(value = "/login") 
	public String autenticarUsuario(Usuario testeLogin) {
	if (repository.autenticar(testeLogin)) {
			return "home";
		}
		else
			return "novo-usuario";
	}
}
