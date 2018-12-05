package br.com.unipe.projeto.projetoMVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unipe.projeto.projetoMVC.entity.Pessoa;

/**
 * Repositorio de Pessoa para persistir dados em banco
 * de dados
 * 
 * @author tiago
 *
 */

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Optional<Pessoa> findByCpf(String cpf);

}
