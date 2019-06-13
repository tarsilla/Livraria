package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@NotBlank(message="Data é uma informação obrigatoria!")
	@Column(name="data")
	private Date data;
	
	@NotBlank(message="Valor Total é uma informação obrigatoria!")
	@Column(name="valorTotal")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
