package br.com.unipe.projeto.projetoMVC.services;

import java.util.List;

import br.com.unipe.projeto.projetoMVC.entity.Conta;

/**
 * Interface da classe ContaService, contendo as instacias dos métodos
 * para serem implementados na classe
 * 
 * @author tiago
 *
 */

public interface ContaServiceImpl {
	
	public Conta salvarConta(Conta conta);
	
	public String saldoConta(Long id);
	
	public List<Conta> listarContas();
	
	public Conta bloquearConta(Long idConta);
	
}
