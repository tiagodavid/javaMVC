package br.com.unipe.projeto.projetoMVC.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.services.ContaService;

/**
 * Controller de Conta contendo as requisições e metodos
 * 
 * @author tiago
 *
 */
@RestController
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	/**
	 * Requisição para inserir uma nova conta no banco
	 * 
	 * @param conta
	 */
	@PostMapping("/criar-conta")
	public ResponseEntity<Conta> criarConta(@Valid @RequestBody Conta conta) {
		
		return new ResponseEntity<>(contaService.salvarConta(conta), HttpStatus.CREATED);
	}
	
	/**
	 * Requisição para listar todas as contas do banco
	 */
	@GetMapping("/contas")
	public ResponseEntity<List<Conta>> listarTodasContas(){
		return new ResponseEntity<>(contaService.listarContas(), HttpStatus.OK);
	}
	
	/**
	 * Requisição para recuperar o saldo de uma conta no banco
	 * @param id
	 */
	@GetMapping("/contas/saldo/{id}")
	public ResponseEntity<String> recuperarSaldo(@PathVariable Long id) {
		return new ResponseEntity<>(contaService.saldoConta(id), HttpStatus.OK);
	}
	
	/**
	 * Requisição para bloquear uma conta
	 * 
	 * @param idConta
	 */
	@PostMapping("/contas/bloquear/{idConta}")
	public ResponseEntity<?> bloquearConta(@PathVariable Long idConta){
		return new ResponseEntity<>(contaService.bloquearConta(idConta), HttpStatus.CREATED);
	}
	
	@PostMapping("/contas/ativar/{idConta}")
	public void ativarConta(@PathVariable long idConta) {
		contaService.ativarConta(idConta);
	}
	
	@DeleteMapping("/contas/excluir/{idConta}")
	public void deletarConta(@PathVariable Long idConta){
		contaService.deletarConta(idConta);
	}
	
	
	
}
