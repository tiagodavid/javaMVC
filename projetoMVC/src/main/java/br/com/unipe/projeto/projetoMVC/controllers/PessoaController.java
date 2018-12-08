package br.com.unipe.projeto.projetoMVC.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.projeto.projetoMVC.entity.Pessoa;
import br.com.unipe.projeto.projetoMVC.services.PessoaService;

/**
 * Controller de Pessoa contendo as requisições e metodos
 * 
 * @author tiago
 *
 */
@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	
	/**
	 * Requisição para inserir uma nova pessoa no banco
	 * 
	 * @param pessoa
	 */
	@PostMapping("/criar-pessoa")
	public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.salvarPessoa(pessoa), HttpStatus.CREATED);
	}
	
	/**
	 * Requisição permite listar todas as pessoas do banco
	 * 
	 */
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> listarTodasPessoas(){
		return new ResponseEntity<>(pessoaService.listarPessoas(), HttpStatus.OK);
	}
	
	@PutMapping("/pessoa/atualiza")
	public ResponseEntity<Pessoa> atualizarPessoa(@Valid @RequestBody Pessoa pessoa){
		return new ResponseEntity<>(pessoaService.atualizarPessoa(pessoa), HttpStatus.OK);
	}
}
