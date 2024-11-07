package it.myBudget.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "mensile")

public class Mensile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String name;
	
	@Column(name = "data_inizio", nullable = false)
	private LocalDate dataInizio;
	
	@Column(name = "data_fine", nullable = false)
	private LocalDate dataFine;
	
	@OneToMany(mappedBy = "mensile")
	public List<Spesa> spese;
	
	@OneToMany(mappedBy = "mensile")
	public List<Introito> introiti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
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
