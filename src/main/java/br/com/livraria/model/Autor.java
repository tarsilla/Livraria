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
	@JoinTable(name="livros-autor")
	private List<Livro> livros = new ArrayList<Livro>();
}
