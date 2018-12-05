package br.com.unipe.projeto.projetoMVC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.projeto.projetoMVC.entity.Pessoa;
import br.com.unipe.projeto.projetoMVC.error.ResourceBadRequestException;
import br.com.unipe.projeto.projetoMVC.repository.PessoaRepository;

/**
 * Classe PessoaService contendo todos os métodos implmentados da interface
 * PessoaServiceImpl Na classe esta contida todas as regras de négocio
 * 
 * @author tiago
 *
 */

@Service
public class PessoaService implements PessoaServiceImpl {

	@Autowired
	private PessoaRepository pessoaRepository;

	/**
	 * O método em questão recebe os dados do tipo Pessoa e persiste no banco de
	 * dados
	 * 
	 * @param pessoa
	 *            variavel do tipo pessoa
	 * 
	 */
	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		Optional<Pessoa> cpfExiste = pessoaRepository.findByCpf(pessoa.getCpf());
		if (cpfExiste.isPresent()) {
			throw new ResourceBadRequestException("Já existe um cpf igual cadastrado");
		}
		return pessoaRepository.save(pessoa);
	}

	/**
	 * O método em questão lista todas as pessoas do meu banco de dados
	 * 
	 */

	@Override
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

}
