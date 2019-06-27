package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Long id;
	
	@Column(nullable = false,length = 10, name="valor")
	@NotBlank(message="Valor é uma informação obrigatoria!")
	private double valor;
	
	@NotBlank(message="Data é uma informação obrigatoria!")
	@Column(name="dataEntregaCorreios")
	private Date dataEntregaCorreios;
	
	@NotBlank(message="Data de Entrega é uma informação obrigatoria!")
	@Column(name="dataEntregaCliente")
	private String dataEntregaCliente;
	
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
	
	public String getDataEntregaCliente() {
		return dataEntregaCliente;
	}

	public void setDataEntregaCliente(String dataEntregaCliente) {
		this.dataEntregaCliente = dataEntregaCliente;
	}

	@NotBlank(message="Total de Dias é uma informação obrigatoria!")
	@Column(name="tempoDias")
	private int tempoDias;
	
	@NotBlank(message="Cidade é uma informação obrigatoria!")
	@Column(name="cidade")
	private String cidade;
	
	@NotBlank(message="Unidade Federativa é uma informação obrigatoria!")
	@Column(name="unidadeF")
	private String unidadeF;
	
	@OneToOne(mappedBy = "itemPedidos")
	public ItemPedido itemPedido;
	
	@OneToOne
	@JoinColumn(name="pedido-id")
	public Pedido pedido;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataEntregaCorreios() {
		return dataEntregaCorreios;
	}

	public void setDataEntregaCorreios(Date dataEntregaCorreios) {
		this.dataEntregaCorreios = dataEntregaCorreios;
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

	public int getTempoDias() {
		return tempoDias;
	}

	public void setTempoDias(int tempoDias) {
		this.tempoDias = tempoDias;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUnidadeF() {
		return unidadeF;
	}

	public void setUnidadeF(String unidadeF) {
		this.unidadeF = unidadeF;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
