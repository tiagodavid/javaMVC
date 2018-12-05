package br.com.unipe.projeto.projetoMVC.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

/**
 * Entidade Transacao com seus respectivos atributos
 * 
 * @author tiago
 *
 */
@Entity
public class Transacao {

	// Atributos da classe Transacao
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTransacao;
	
	@ManyToOne
	@JoinColumn(name="idConta")
	private Conta idConta;
	
	@NotNull(message="O campo valor não deve ser nulo")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor;
	
	@Temporal(TemporalType.DATE)
	private Date dataTransacao;

	
	// Construtores
	public Transacao() {
		
	}
	
	public Transacao(Long idTransacao, Conta idConta, BigDecimal valor, Date dataTransacao){
		this.idTransacao = idTransacao;
		this.idConta = idConta;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
	}
	
	// Getters e Setters
	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}


	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public Conta getIdConta() {
		return idConta;
	}

	public void setIdConta(Conta idConta) {
		this.idConta = idConta;
	}
	
	
	
	
}
