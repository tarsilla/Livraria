package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id_Usuario;
	
	@Column(nullable = false,length = 70)
	@NotBlank(message = "Informação Obrigatoria")
	private String nome;
	
	@Column(nullable = false,length = 70)
	@NotBlank(message = "Informação Obrigatoria")
	private String email;
	
	@Column(nullable = false,length = 30)
	@NotBlank(message = "Informação Obrigatoria")
	private String senha;
	
	@Column(nullable = false,length = 50)
	@NotBlank(message = "Informação Obrigatoria")
	private String rua;
	
	@Column(nullable = false,length = 50)
	@NotBlank(message = "Informação Obrigatoria")
	private String bairro;
}
