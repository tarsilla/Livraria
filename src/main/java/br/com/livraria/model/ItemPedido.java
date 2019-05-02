package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ItemPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id_ItemPedido;
	
	@NotBlank(message="Informação obrigatoria")
	private int quantidade;
	
	@NotBlank(message="Informação obrigatoria")
	private double valorTotal;
}
