package br.com.livraria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "autor")
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false, length=70, name="nome")
	@NotBlank(message="Nome é uma informação obrigatoria!")
	private String nome;

	@Column(nullable=false, length=70,name="email")
	@NotBlank(message="Email é uma informação obrigatoria!")
	private String email;
	
	@NotBlank(message="Cpf é uma informação obrigatoria!")
	@Column(name="cpf")
	private int cpf;
	
	@ManyToMany
	@JoinTable(name="autores")
	private List<Livro> livros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
