package br.com.unipe.projeto.projetoMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unipe.projeto.projetoMVC.entity.Conta;

/**
 * Repositorio de Conta para persistir dados em banco
 * de dados
 * 
 * @author tiago
 *
 */

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
