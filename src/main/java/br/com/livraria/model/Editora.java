package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Editora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_Editora;
	
	@Column(nullable=false, length=70)
	@NotBlank(message="Informação obrigatoria")
	private String nome;
	
	@Column(nullable=false, length=50)
	@NotBlank(message="Informação obrigatoria")
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name="id-livro")
	private Livro livro;

	public Long getId_Editora() {
		return id_Editora;
	}

	public void setId_Editora(Long id_Editora) {
		this.id_Editora = id_Editora;
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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
