package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_Livro;
	
	@NotBlank(message = "Informação Obrigatoria")
	private String titulo;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int ano;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int sinopse;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int isbn;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int edicao;
	
	@NotBlank(message = "Informação Obrigatoria")
	private double peso;
}
