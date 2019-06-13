package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_Livro;
	
	@NotBlank(message = "Informação Obrigatoria")
	private String titulo;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int ano;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int sinopse;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int isbn;
	
	@NotBlank(message = "Informação Obrigatoria")
	private int edicao;
	
	@NotBlank(message = "Informação Obrigatoria")
	private double preço;
	
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

	public int getId_Livro() {
		return id_Livro;
	}

	public void setId_Livro(int id_Livro) {
		this.id_Livro = id_Livro;
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

	public void setPreçp(double preço) {
		this.preço = preço;
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
}