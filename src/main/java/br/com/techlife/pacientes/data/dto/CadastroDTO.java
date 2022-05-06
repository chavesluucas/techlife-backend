package br.com.techlife.pacientes.data.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.techlife.pacientes.data.entity.Cadastro;
import br.com.techlife.pacientes.data.enums.Prioridade;

public class CadastroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private Integer idade;
	private String endereco;
	private Instant dataAtendimento;
	private Integer prioridade;
	
	public CadastroDTO() {}

	public CadastroDTO(Integer id, String nome, Integer idade, String endereco, Instant dataAtendimento, Prioridade prioridade) {
		
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.dataAtendimento = dataAtendimento;
		setPrioridade(prioridade);
	}
	
	public Cadastro convertToEntity() {
		return new Cadastro(getId(), getNome(), getIdade(), getEndereco(), getDataAtendimento(), getPrioridade());
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Instant getDataAtendimento() {
		return dataAtendimento;
	}


	public void setDataAtendimento(Instant dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Prioridade getPrioridade() {
		return Prioridade.valueOf(prioridade);
	}


	public void setPrioridade(Prioridade prioridade) {
		if(prioridade != null) {
			this.prioridade = prioridade.getCode();			
		}
	}
	
}
