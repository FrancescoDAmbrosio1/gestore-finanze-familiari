package it.myBudget.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Introiti")

public class Introito {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "data", nullable = false)
private LocalDate data;

@Column(name = "importo", nullable = false)
private Double importo;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private Utente utente;

@NotNull(message = "La scelta della categoria è obbligatoria")
@ManyToOne
@JoinColumn(name = "categoria_Introiti_id")
private CategoriaIntroiti categoriaIntroito;

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

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}

public Double getImporto() {
	return importo;
}

public void setImporto(Double importo) {
	this.importo = importo;
}

public Utente getUtente() {
	return utente;
}

public void setUtente(Utente utente) {
	this.utente = utente;
}

public CategoriaIntroiti getCategoriaIntroito() {
	return categoriaIntroito;
}

public void setCategoriaIntroito(CategoriaIntroiti categoriaIntroito) {
	this.categoriaIntroito = categoriaIntroito;
}

public Mensile getMensile() {
	return mensile;
}

public void setMensile(Mensile mensile) {
	this.mensile = mensile;
}



}
