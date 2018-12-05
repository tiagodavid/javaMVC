package br.com.unipe.projeto.projetoMVC.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entidade Pessoa com seus respectivos atributos
 * 
 * @author tiago
 *
 */
@Entity
public class Pessoa {
	
	// Atributos da classe Pessoa
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPessoa;
	
	@NotBlank(message="O campo nome é obrigatório")
	private String nome;
	
	@NotBlank(message="O campo cpf é obrigatório")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Long idPessoa, String nome, String cpf, Date dataNascimento) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters e Setters
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	} 
	
	
	
	
}
