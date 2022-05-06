package br.com.techlife.pacientes.data.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.techlife.pacientes.data.dto.CadastroDTO;
import br.com.techlife.pacientes.data.enums.Prioridade;

@Entity
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private String endereco;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataAtendimento;
	
	
	private Integer prioridade;
	
	public Cadastro () { }


	public Cadastro(Integer id, String nome, Integer idade, String endereco, Instant dataAtendimento, Prioridade prioridade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.dataAtendimento = dataAtendimento;
		setPrioridade(prioridade);
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


	public CadastroDTO getDTO(){
		return new CadastroDTO(getId(), getNome(), getIdade(), getEndereco(), getDataAtendimento(), getPrioridade());
	}

	
}
