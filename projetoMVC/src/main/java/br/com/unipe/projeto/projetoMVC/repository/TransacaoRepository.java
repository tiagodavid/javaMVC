package br.com.unipe.projeto.projetoMVC.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.entity.Transacao;

/**
 * Repositorio de Transacao para persistir dados em banco
 * de dados
 * 
 * @author tiago
 *
 */

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
	
	List<Transacao> findByIdContaAndDataTransacao(Conta idConta, Date data);
	List<Transacao> findByIdConta(Conta idConta);
}
