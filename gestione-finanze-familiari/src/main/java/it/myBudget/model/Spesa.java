package it.myBudget.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;

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
	private Double importo;
	
	@NotBlank(message = "L'inserimento della data è obbligatorio")
	@Column(name = "data")
	private LocalDate data;
	
	@Column(name = "giorno_valuta")
	private Integer valuta;
	
	@Column(name = "spesa_fissa")
	private boolean spesaFissa;
	
	@Column(name = "note", nullable = true)
	private String note;
	
//	@NotNull(message = "La scelta dell'operatore è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Utente utente;
	
	@NotNull(message = "La scelta della categoria è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private CategoriaSpesa categoriaSpesa;
	
	@NotNull(message = "La scelta del mensile è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "mensile_id")
	private Mensile mensile;

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

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Integer getValuta() {
		return valuta;
	}

	public void setValuta(Integer valuta) {
		this.valuta = valuta;
	}

	public boolean isSpesaFissa() {
		return spesaFissa;
	}

	public void setSpesaFissa(boolean spesaFissa) {
		this.spesaFissa = spesaFissa;
	}

	public CategoriaSpesa getCategoriaSpesa() {
		return categoriaSpesa;
	}

	public void setCategoriaSpesa(CategoriaSpesa categoriaSpesa) {
		this.categoriaSpesa = categoriaSpesa;
	}

	public Mensile getMensile() {
		return mensile;
	}

	public void setMensile(Mensile mensile) {
		this.mensile = mensile;
	}
	
	

}
