package com.floatsystem.mvc.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.floatsystem.mvc.springboot.app.entity.Usuario;

@Controller
public class RegisterController {
	
	@GetMapping("/registro")
	public String usuarioData(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setName("Óscar");
		usuario.setEmail("oscarforjuela@hotmail.com");
		usuario.setId(123255);
		
		model.addAttribute("titu", "Bienvenidos a FloatSystem");
		model.addAttribute("usuario", usuario);
		
		return "formulario";
	}//Mostrando datos del usuario registrado
	
	@PostMapping
	public String usuarioNuevo(Usuario usuario,  Model model) {
		
		
		
		return "";
	}

}
