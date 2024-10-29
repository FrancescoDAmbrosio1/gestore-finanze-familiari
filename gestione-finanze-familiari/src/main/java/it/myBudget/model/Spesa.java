package it.myBudget.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "spese")

public class Spesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "L'inserimento del nome è obbligatorio")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotBlank(message = "L'inserimento dell'importo è obbligatorio")
	@Column(name = "importo", nullable = false)
	private Integer importo;
	
	@NotBlank(message = "L'inserimento della data è obbligatorio")
	@Column(name = "data")
	private LocalDate data;
	
//	@NotNull(message = "La scelta dell'operatore è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Utente utente;
	

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

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	

}
