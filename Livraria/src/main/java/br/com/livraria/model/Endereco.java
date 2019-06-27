package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false,length = 50, name="nome")
	@NotBlank(message="Cep é uma informação obrigatoria!")
	private String cep;
	
	@Column(name = "rua", length = 100)
	@NotBlank(message="Rua é uma informação obrigatoria!")
	private String rua;

	@Column(name = "bairro", length = 45)
	@NotBlank(message="Bairro é uma informação obrigatoria!")
	private String bairro;

	@Column(name = "numero")
	@NotBlank(message="Numero é uma informação obrigatoria!")
	private int numero;
	
	@Column(name = "complemento")
	@NotBlank(message="Complemento é uma informação obrigatoria!")
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
