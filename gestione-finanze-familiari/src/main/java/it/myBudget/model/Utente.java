package it.myBudget.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="utenti")

public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "L'inserimento del nome è obbligatorio")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotBlank(message = "L'inserimento del cognome è obbligatorio")
	@Column(name = "cognome", nullable = false)
	private String cognome;
	
	@NotBlank(message = "L'inserimento della email è obbligatorio")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "L'inserimento della password è obbligatorio")
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "url-img-personale")
	private String imgPersonale;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	@OneToMany(mappedBy = "utente")
	public List<Spesa> spese;
	
	@OneToMany(mappedBy = "utente")
	public List<Introito> introiti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgPersonale() {
		return imgPersonale;
	}

	public void setImgPersonale(String imgPersonale) {
		this.imgPersonale = imgPersonale;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}

	public List<Introito> getIntroiti() {
		return introiti;
	}

	public void setIntroiti(List<Introito> introiti) {
		this.introiti = introiti;
	}
	
	
	
}
