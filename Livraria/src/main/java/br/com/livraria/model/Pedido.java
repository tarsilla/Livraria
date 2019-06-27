package br.com.livraria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

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
	
	@NotBlank(message="Data é uma informação obrigatoria!")
	@Column(name="data")
	private Date data;
	
	@NotBlank(message="Valor Total é uma informação obrigatoria!")
	@Column(name="valorTotal")
	private double valorTotal;
	
	@NotBlank(message="Status do Peido é uma informação obrigatoria!")
	private StatusPedido statusPedido;
	
	@ManyToOne
	@JoinColumn(name="usuario-id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pedidos")
	private List<Livro> livro;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
