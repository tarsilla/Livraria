package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_Municipio;
	
	@Column(nullable=false, length = 70)
	@NotBlank(message = "Informação Obrigatoria")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id-estado")
	private Estado estado;
}
