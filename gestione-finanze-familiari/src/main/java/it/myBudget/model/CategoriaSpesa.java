package it.myBudget.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "categorie")

public class CategoriaSpesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "L'inserimento del nome della categoria è obbligatorio")
	@Column(name = "nome", nullable = false, unique = true)
	private String nome;
	
//	@NotBlank(message = "L'inserimento dell'icona è obbligatorio")
//	@Column(name = "url-icona", nullable = false, unique = true)
//	private String icona;
	
	@NotBlank(message = "L'inserimento della descrizione della categoria è obbligatorio")
	@Column(name = "note")
	private String note;
	
	@NotNull(message ="Specificare il tipo di categoria")
	@Column(name = "tipo")
	private String tipo;
	
	@OneToMany(mappedBy = "categoriaSpesa")
	public List<Spesa> spese;

	@NotNull(message = "La scelta del'icona è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "icona_id")
	private Icona icona;
	
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



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Icona getIcona() {
		return icona;
	}

	public void setIcona(Icona icona) {
		this.icona = icona;
	}

	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
