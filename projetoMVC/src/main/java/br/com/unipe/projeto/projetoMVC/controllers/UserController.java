package br.com.unipe.projeto.projetoMVC.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/users")
	@ResponseBody
	public String getUser() {
		return "{\"users\":[{\"name\":\"Lucas\",\"country\":\"Brazil\"},"+
				"{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
}
