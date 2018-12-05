package br.com.unipe.projeto.projetoMVC.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

/**
 * Entidade Pessoa com seus atributos
 * 
 * @author tiago
 *
 */
@Entity
public class Conta {
	
	// Atributos da classe Conta
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConta;
	
	@ManyToOne
	private Pessoa idPessoa;
	
	@NotNull(message="O campo saldo é obrigatório")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal saldo;
	
	@NotNull(message="O campo limiteSaqueDiario é obrigatório")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal limiteSaqueDiario;
	
	@NotNull(message="O campo flagAtivo é obrigatório")
	private Boolean flagAtivo;
	
	@NotNull(message="O campo tipoConta é obrigatório")
	private Long tipoConta;
	
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	public Conta() {
	}
	
	public Conta(Long idConta, Pessoa idPessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, Boolean flagAtivo, Long tipoConta, Date dataCriacao) {
		this.idConta = idConta;
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = dataCriacao;
	}

	// Getters e Setters
	public Long getIdconta() {
		return idConta;
	}

	public void setIdconta(Long idConta) {
		this.idConta = idConta;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public Long getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Long tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Override
	public String toString() {
	
		return "O saldo em conta é: " + this.saldo;
	}
}
