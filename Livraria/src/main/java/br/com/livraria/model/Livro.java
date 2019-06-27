package br.com.livraria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "livro")
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message="Titulo é uma informação obrigatoria!")
	@Column(name="titulo")
	private String titulo;
	
	@NotBlank(message="Ano é uma informação obrigatoria!")
	@Column(name="ano")
	private int ano;
	
	@NotBlank(message="Sinopse é uma informação obrigatoria!")
	@Column(name="sinopse")
	private int sinopse;
	
	@NotBlank(message="Isbn é uma informação obrigatoria!")
	@Column(name="isbn")
	private int isbn;
	
	@NotBlank(message="Edição é uma informação obrigatoria!")
	@Column(name="edicao")
	private int edicao;
	
	@NotBlank(message="Preço é uma informação obrigatoria!")
	@Column(name="preco")
	private double preço;
	
	@NotBlank(message="Peso é uma informação obrigatoria!")
	@Column(name="peso")
	private double peso;
	
	@Lob
	private byte [] foto;
	
	@ManyToMany
	@JoinTable(name = "livro-autor")
	private List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(name = "pedido-id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "categoria-id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="editora-id")	
	private Editora editora;
	
	@ManyToMany(mappedBy="livros")
	public List<ItemPedido> itemPedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSinopse() {
		return sinopse;
	}

	public void setSinopse(int sinopse) {
		this.sinopse = sinopse;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}