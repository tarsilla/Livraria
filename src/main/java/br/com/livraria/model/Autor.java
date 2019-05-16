package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_Autor;
	
	@Column(nullable=false, length=70)
	@NotBlank(message="Informação obrigatoria")
	private String nome;

	@Column(nullable=false, length=70)
	@NotBlank(message="Informação obrigatoria")
	private String email;
	
	@NotBlank(message="Informação obrigatoria")
	private int cpf;
	
	@ManyToMany
	@JoinTable(name="livro-autor")
	private List<Livro> livros = new ArrayList<Livro>();
	
	public int getId_Autor() {
		return id_Autor;
	}

	public void setId_Autor(int id_Autor) {
		this.id_Autor = id_Autor;
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
}
