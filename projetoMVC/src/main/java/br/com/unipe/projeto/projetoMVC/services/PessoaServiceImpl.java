package br.com.unipe.projeto.projetoMVC.services;

/**
 * Interface da classe PessoaService, contendo as instacias dos métodos
 * para serem implementados na classe
 * 
 * @author tiago
 */

import java.util.List;

import br.com.unipe.projeto.projetoMVC.entity.Pessoa;

public interface PessoaServiceImpl {
	
	public Pessoa salvarPessoa(Pessoa pessoa);
	
	public List<Pessoa> listarPessoas();
	
}
