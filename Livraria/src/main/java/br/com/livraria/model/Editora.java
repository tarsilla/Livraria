package br.com.livraria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "editora")
public class Editora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=70, name="nome")
	@NotBlank(message="Nome é uma informação obrigatoria!")
	private String nome;
	
	@Column(nullable=false, length=50, name="cidade")
	@NotBlank(message="Cidade é uma informação obrigatoria!")
	private String cidade;

	@OneToMany(mappedBy="editoras")
	private List<Livro> livro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
