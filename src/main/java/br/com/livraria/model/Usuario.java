package br.com.livraria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false,length = 70)
	@NotBlank(message = "Informação Obrigatoria")
	private String nome;
	
	@Column(nullable = false,length = 70)
	@NotBlank(message = "Informação Obrigatoria")
	private String email;
	
	@Column(nullable = false,length = 30)
	@NotBlank(message = "Informação Obrigatoria")
	private String senha;
	
	@Column(nullable = false,length = 30)
	@NotBlank(message = "Informação Obrigatoria")
	private String Confirmarsenha;

	@Column(nullable = false,length = 50)
	@NotBlank(message = "Informação Obrigatoria")
	private String rua;
	
	@Column(nullable = false,length = 50)
	@NotBlank(message = "Informação Obrigatoria")
	private String bairro;
	
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
	
	public String getConfirmarsenha() {
		return Confirmarsenha;
	}

	public void setConfirmarsenha(String confirmarsenha) {
		Confirmarsenha = confirmarsenha;
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
}
