package br.com.unipe.projeto.projetoMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.error.ResourceNotFoundException;
import br.com.unipe.projeto.projetoMVC.repository.ContaRepository;
import br.com.unipe.projeto.projetoMVC.repository.PessoaRepository;

/**
 * Classe ContaService contendo todos os métodos implmentados da interface
 * ContaServiceImpl Na classe esta contida todas as regras de négocio
 * 
 * @author tiago
 *
 */

@Service
public class ContaService implements ContaServiceImpl {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	/**
	 * O método em questão recebe os dadados do Tipo Conta e persiste no banco de
	 * dados
	 * 
	 * @param conta
	 *            variavel do tipo conta
	 */
	@Override
	public Conta salvarConta(Conta conta) {
		conta.setIdPessoa(pessoaRepository.findOne(conta.getIdPessoa().getIdPessoa()));
		return contaRepository.save(conta);
	}

	/**
	 * O método em questão permite recuperar o saldo de uma conta
	 * 
	 * @param id
	 */
	@Override
	public String saldoConta(Long id) {
		Conta conta = contaRepository.findOne(id);
		if (conta == null)
			throw new ResourceNotFoundException("Nenhuma conta encontrada para esse id:" + id);
		return conta.toString();
	}

	/**
	 * O método em questão permite listar todas as constas contidas no meu banco de
	 * dados
	 * 
	 */
	@Override
	public List<Conta> listarContas() {
		return contaRepository.findAll();
	}

	/**
	 * O método em questão permite bloquear uma conta através do idConta
	 * 
	 * @param idConta
	 */

	@Override
	public Conta bloquearConta(Long idConta) {
		Conta conta = contaRepository.findOne(idConta);
		conta.setFlagAtivo(false);
		return contaRepository.save(conta);
	}

	public void ativarConta(long idConta) {
		Conta conta = contaRepository.findOne(idConta);
		conta.setFlagAtivo(true);
		contaRepository.save(conta);
	}

	public void deletarConta(Long idConta) {
		contaRepository.delete(idConta);
	}

}
