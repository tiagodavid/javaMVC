package br.com.unipe.projeto.projetoMVC.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.entity.Transacao;
import br.com.unipe.projeto.projetoMVC.services.TransacaoService;

/**
 * 
 * Controller de Transacao contendo as requisições e métodos
 * 
 * @author tiago
 *
 */
@RestController
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;

	/**
	 * Requisição para efetuar deposito em uma conta
	 * 
	 * @param transacao
	 */
	@PostMapping("transacao/deposito")
	public ResponseEntity<?> depositarEmConta(@RequestBody Transacao transacao) {
		return new ResponseEntity<>(transacaoService.depositar(transacao), HttpStatus.CREATED);
	}

	/**
	 * Requisição para efetuar um saque em uma conta
	 * 
	 * @param transacao
	 * @return
	 */
	@PostMapping("transacao/saque")
	public ResponseEntity<Transacao> sacarEmConta(@Valid @RequestBody Transacao transacao) {
		return new ResponseEntity<>(transacaoService.sacar(transacao), HttpStatus.CREATED);
	}

	/**
	 * Requisição para recuperar o extrato de uma conta
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/transacao/extrato/{id}")
	public ResponseEntity<List<Transacao>> extrato(@PathVariable Conta id) {
		return new ResponseEntity<>(transacaoService.findByIdConta(id), HttpStatus.OK);
	}

	/**
	 * Requisição para recuperar o a soma de saques de uma conta em determinado dia
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/limite/{id}")
	public ResponseEntity<BigDecimal> limite(@PathVariable Conta id) {
		return new ResponseEntity<>(transacaoService.verificarLimiteDiario(id), HttpStatus.OK);
	}

}
