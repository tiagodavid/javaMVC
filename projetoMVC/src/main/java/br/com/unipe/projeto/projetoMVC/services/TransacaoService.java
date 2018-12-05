package br.com.unipe.projeto.projetoMVC.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.projeto.projetoMVC.entity.Conta;
import br.com.unipe.projeto.projetoMVC.entity.Transacao;
import br.com.unipe.projeto.projetoMVC.error.ResourceBadRequestException;
import br.com.unipe.projeto.projetoMVC.error.ResourceNotFoundException;
import br.com.unipe.projeto.projetoMVC.repository.ContaRepository;
import br.com.unipe.projeto.projetoMVC.repository.TransacaoRepository;

/**
 * Classe TransacaoService contendo todos os métodos implmentados da interface
 * TransacaoServiceImpl Na classe esta contida todas as regras de négocio
 * 
 * @author tiago
 *
 */

@Service
public class TransacaoService implements TransacaoServiceImpl {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	/**
	 * O método em questão recebe um objeto do tipo Transacao e persiste no banco de
	 * dados, permitindo efetuar um deposito. o mesmo só sera possivel se a conta
	 * não estiver bloqueada
	 * 
	 * @param transacao
	 *            variavel do tipo Transacao
	 */
	@Override
	public Transacao depositar(Transacao transacao) {
	
		Conta conta = contaRepository.findOne(transacao.getIdConta().getIdconta());
	

		if (conta.getFlagAtivo() == true) {
			System.out.println("Entrou if");
			conta.setSaldo(conta.getSaldo().add(transacao.getValor()));
			transacao.setDataTransacao(new Date());
			contaRepository.save(conta);

			return transacaoRepository.save(transacao);
		}

		throw new ResourceBadRequestException("A conta está bloqueada");

	}

	/**
	 * O método em questão recebe um objeto do tipo Transacao e persiste no banco de
	 * dados, permitindo efetuar um saque. O mesmo não será possivel caso a conta
	 * esteja bloqueada, o valor do saque seja maior do que o disponivel em saldo e
	 * não pode ter excedido o valor do limite diario. O valor de entrada da
	 * transacao deve ser passado como valor negativo. Ex(-200)
	 * 
	 * @param transacao
	 *            variavel do tipo Transacao
	 */
	@Override
	public Transacao sacar(Transacao transacao) {

		transacao.setDataTransacao(new Date());

		Conta conta = contaRepository.findOne(transacao.getIdConta().getIdconta());
		BigDecimal saquesTotais = verificarLimiteDiario(conta);

		saquesTotais = saquesTotais.subtract(transacao.getValor());

		if ((conta.getSaldo().compareTo(transacao.getValor()) > 0)
				&& conta.getLimiteSaqueDiario().compareTo(saquesTotais) > 0 && conta.getFlagAtivo() == true) {

			conta.setSaldo(conta.getSaldo().add(transacao.getValor()));
			contaRepository.save(conta);
			return transacaoRepository.save(transacao);
		}

		throw new ResourceBadRequestException(
				"Não pode efetuar o saque pois ou o valor do saque é maior do que o saldo ou já atingiu o seu limites de saques ou sua conta está bloqueada");
	}

	/**
	 * O método em questão lista todas as tranções de uma determinada conta
	 * 
	 * @param idConta
	 *            Variavel do tipo Conta
	 */
	@Override
	public List<Transacao> findByIdConta(Conta idConta) {
		List<Transacao> extrato = transacaoRepository.findByIdConta(idConta);
		if (extrato.isEmpty())
			throw new ResourceNotFoundException("Não existe nenhuma transacao atribuida a essa conta");
		return transacaoRepository.findByIdConta(idConta);
	}

	/**
	 * O método em quenstão busca todas as transações de saque de uma determinada
	 * conta em uma determinada data
	 * 
	 * @param idConta
	 *            Variavel do tipo Conta
	 */
	@Override
	public BigDecimal verificarLimiteDiario(Conta idConta) {
		Date data = new Date();
		List<Transacao> listarTransacoes = transacaoRepository.findByIdContaAndDataTransacao(idConta, data);
		BigDecimal valorTotal = new BigDecimal(0);

		for (Transacao transacao : listarTransacoes) {
			if (transacao.getValor().compareTo(new BigDecimal(0)) < 0) {
				valorTotal = valorTotal.subtract(transacao.getValor());
				return valorTotal;
			}
		}
		return valorTotal;
	}

}
