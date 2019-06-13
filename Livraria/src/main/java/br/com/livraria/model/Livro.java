package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	@Lob
	private byte [] foto;
	
	@ManyToMany(mappedBy="livros")	 
	private List<Autor> autores = new ArrayList<Autor>();
	
	@ManyToMany(mappedBy="livros")
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	@ManyToMany
	@JoinTable(name="livros-categoria")
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@ManyToOne
	@JoinColumn(name="id-editora")	
	private Editora editora;

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}