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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "frete")
public class Frete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false,length = 10, name="valor")
	@NotBlank(message="Valor é uma informação obrigatoria!")
	private int valor;
	
	@NotBlank(message="Data é uma informação obrigatoria!")
	@Column(name="dataEntregaCorreios")
	private Date dataEntregaCorreios;
	
	@NotBlank(message="Data de Entrega é uma informação obrigatoria!")
	@Column(name="dataEntregaCliente")
	private Date dataEntregaCliente;
	
	@Column(nullable = false,length = 10,name="peso")
	private double peso;
	
	@Column(nullable = false,length = 10,name="cepOrigem")
	@NotBlank(message="Cep de Origem de é uma informação obrigatoria!")
	private String cepOrigem;
	
	@Column(nullable = false,length = 10, name="cepDestino")
	@NotBlank(message="Cep de Destino é uma informação obrigatoria!")
	private String cepDestino;
	
	@NotBlank(message="Rua é uma informação obrigatoria!")
	@Column(name="rua")
	private String rua;
	
	@NotBlank(message="Bairro é uma informação obrigatoria!")
	@Column(name="bairro")
	private String bairro;
	
	@OneToOne
	@JoinColumn(name="id-endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy="frete")
	private List<Pedido> pedidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Date getDataEntregaCorreios() {
		return dataEntregaCorreios;
	}

	public void setDataEntregaCorreios(Date dataEntregaCorreios) {
		this.dataEntregaCorreios = dataEntregaCorreios;
	}

	public Date getDataEntregaCliente() {
		return dataEntregaCliente;
	}

	public void setDataEntregaCliente(Date dataEntregaCliente) {
		this.dataEntregaCliente = dataEntregaCliente;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	//public Endereco getEndereco() {
	//	return endereco;
	//}

	//public void setEndereco(Endereco endereco) {
	//	this.endereco = endereco;
	//}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
