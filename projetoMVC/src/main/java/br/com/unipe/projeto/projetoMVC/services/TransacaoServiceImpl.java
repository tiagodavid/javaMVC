package br.com.unipe.projeto.projetoMVC.services;

import java.math.BigDecimal;
import java.util.List;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.entity.Transacao;

/**
 * Interface da classe TransacaoService, contendo as instacias dos métodos
 * para serem implementados na classe
 * 
 * @author tiago
 *
 */

public interface TransacaoServiceImpl {
	
	public Transacao depositar(Transacao transacao);
	public Transacao sacar(Transacao transacao);
	public List<Transacao> findByIdConta(Conta idConta);
	public BigDecimal verificarLimiteDiario(Conta idConta);
	
	
}
