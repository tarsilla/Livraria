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
	
	@ManyToMany(mappedBy = "ctegorias")
	private List<Livro> livros = new ArrayList<Livro>();
}
