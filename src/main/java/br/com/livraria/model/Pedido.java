package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToMany
	@JoinTable(name="pedidos-livros")
	private List<Livro> livros = new ArrayList<Livro>();
	
	@ManyToOne
	@JoinColumn(name="id-usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id-frete")
	private Frete frete;
	
	
}
