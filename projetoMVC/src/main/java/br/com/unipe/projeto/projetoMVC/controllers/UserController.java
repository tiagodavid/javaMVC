package br.com.unipe.projeto.projetoMVC.controllers;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.projeto.projetoMVC.entity.User;

@RestController
@CrossOrigin(value="http://localhost:4200")
public class UserController {
	
	@PostMapping("/sad")
	public boolean login(@RequestBody User user) {
		return user.getUsername().equals("user") && user.getPassword().equals("password");
	}
	
	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}
	
}
