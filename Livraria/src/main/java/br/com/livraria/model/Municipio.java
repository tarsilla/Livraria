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

@Entity
@Table(name = "municipio")
public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_Municipio;
	
	@Column(nullable=false, length = 70, name="nome")
	@NotBlank(message = "Municipio é uma informação Obrigatoria!")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id-estado")
	private Estado estado;

	public int getId_Municipio() {
		return id_Municipio;
	}

	public void setId_Municipio(int id_Municipio) {
		this.id_Municipio = id_Municipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
