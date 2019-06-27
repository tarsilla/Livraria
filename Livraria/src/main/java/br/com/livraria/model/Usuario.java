package br.com.livraria.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario() {
		this.enabled = true;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false,length = 70,name="nome")
	@Size(min = 4, message = "O nome deve ter pelo menos 4 caracteres")
	private String nome;
	
	@Column(nullable = false,length = 70, name="email")
	@NotBlank(message = "Email é uma informação Obrigatoria!")
	private String email;
	
	@Column(nullable = false,length = 70, name="email")
	@NotBlank(message = "User é uma informação Obrigatoria!")
	@Size(min = 6, message = "User deve ter no minimo 6 letras!")
	private String username;
	
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
	
	@Column(nullable = false,length = 50, name="cep")
	@NotBlank(message="Cep é uma informação obrigatoria!")
	private String cep;
	
	@Column(nullable = false,length = 100, name="municipio")
	@NotBlank(message="Municipio é uma informação obrigatoria!")
	private String municipio;
	
	@Column(nullable = false,length = 50, name="unidadeF")
	@NotBlank(message="Unidade Federativa é uma informação obrigatoria!")
	private String unidadeF;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcesso;
	
	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "cidade-id")
	private Cidade cidade;
	
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedido;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private Set<Role> role = new HashSet<Role>();

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

	public String getUsername() {
		return this.email;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUnidadeF() {
		return unidadeF;
	}

	public void setUnidadeF(String unidadeF) {
		this.unidadeF = unidadeF;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getRoleString() {
		String txt="";
		if(role!=null) {
			for(Role r: role) {
				txt+= r.getNome() + ", "; 
			}
		}
		return txt;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.addAll(getRole());
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}
}
