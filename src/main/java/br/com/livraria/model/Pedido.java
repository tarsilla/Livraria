package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_Pedido;
	
	@NotBlank(message="Informação obrigatoria")
	private Date data;
	
	@NotBlank(message="Informação obrigatoria")
	private double valorTotal;
	
}
