package br.com.livraria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	private String rua;

	@Column(name = "bairro", length = 45)
	private String bairro;

	@Column(name = "numero")
	private int numero;
	
	@OneToOne
	@JoinColumn(name = "id-estado")
	private Estado estado;

	@OneToOne
	@JoinColumn(name = "Cidade_id")
	private Municipio municipio;
	
	public Endereco(Long id, @NotNull String rua, @NotNull String bairro, @NotNull int numero, Estado estado,
			Municipio municipio) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.estado = estado;
		this.municipio = municipio;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getShortEndereco() {
		return "" + getNumero() + " " + getRua() + "," + getBairro() + "," + getMunicipio().getNome() + ","
				+ getEstado().getUf();
	}
	
	@Override
	public String toString() {
		return "" + getNumero() + " " + getRua() + "," + getBairro() + "," + getMunicipio().getNome() + ","
				+ getEstado().getUf();
	}
}
