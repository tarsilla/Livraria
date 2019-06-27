package br.com.livraria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "itemPedido")
public class ItemPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message="Quantidade é uma informação obrigatoria!")
	@Column(name="quantidade")
	private int quantidade;
	
	@NotBlank(message="Valor Total é uma informação obrigatoria!")
	@Column(name="valorTotal")
	private double valorTotal;

	@NotBlank(message="Cep é uma informação obrigatoria!")
	@Column(name="cep")
	private String cep;
	
	@NotBlank(message="Preço é uma informação obrigatoria!")
	@Column(name="preco")
	private String preco;
	
	@NotBlank(message="Prazo é uma informação obrigatoria!")
	@Column(name="prazo")
	private String prazo;
	
	@OneToOne
	@JoinColumn(name="frete-id")
	public Frete frete;
	
	@ManyToOne
	public Pedido pedido;
	
	@ManyToMany
	@JoinTable(name="livrosPedido")
	public List<Livro> livro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
