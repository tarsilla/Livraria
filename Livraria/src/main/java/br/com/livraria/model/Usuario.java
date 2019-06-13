package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false,length = 70,name="nome")
	@Size(min = 4, message = "O nome deve ter pelo menos 4 caracteres")
	private String nome;
	
	@Column(nullable = false,length = 70, name="email")
	@NotBlank(message = "Email é uma informação Obrigatoria!")
	private String email;
	
	@Column(nullable = false,length = 30, name="senha")
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
	private String senha;
	
	@Column(nullable = false,length = 50, name="rua")
	@NotBlank(message="Rua é uma informação obrigatoria!")
	private String rua;
	
	@Column(nullable = false,length = 50, name="bairro")
	@NotBlank(message="Bairro é uma informação obrigatoria!")
	private String bairro;
	
	@Column(nullable = false,length = 50, name="numero")
	@NotBlank(message="Numero é uma informação obrigatoria!")
	private String numero;
	
	@Column(nullable = false,length = 50, name="tipo")
	@NotBlank(message = "Tipo é uma informação Obrigatoria!")
	private String tipo;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "endereco_id")
	@JsonIgnore
	private Endereco endereco;
	
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
