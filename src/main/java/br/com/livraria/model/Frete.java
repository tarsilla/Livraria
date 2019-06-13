package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Frete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id_Frete;
	
	@Column(nullable = false,length = 10)
	@NotBlank(message = "Informação Obrigatoria")
	private int valor;
	
	@NotBlank(message = "Informação Obrigatoria")
	private Date dataEntregaCorreios;
	
	@NotBlank(message = "Informação Obrigatoria")
	private Date dataEntregaCliente;
	
	@NotBlank(message = "Informação Obrigatoria")
	private double peso;
	
	@Column(nullable = false,length = 10)
	@NotBlank(message = "Informação Obrigatoria")
	private String cepOrigem;
	
	@Column(nullable = false,length = 10)
	@NotBlank(message = "Informação Obrigatoria")
	private String cepDestino;
	
	@NotBlank(message = "Informação Obrigatoria")
	private String rua;
	
	@NotBlank(message = "Informação Obrigatoria")
	private String bairro;
	
	@OneToOne
	@JoinColumn(name="id-municipio")
	private Municipio municipio;
	
	@OneToMany(mappedBy="frete")
	private List<Pedido> pedidos;
	

}
