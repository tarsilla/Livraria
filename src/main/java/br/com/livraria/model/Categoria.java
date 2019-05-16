package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_Categoria;
	
	@Column(nullable=false, length=70)
	@NotBlank(message="Informação obrigatoria")
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Livro> livros = new ArrayList<Livro>();

	public Long getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(Long id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}
