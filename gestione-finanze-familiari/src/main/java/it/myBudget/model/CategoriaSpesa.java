package it.myBudget.model;

import java.util.List;

//import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "categorie")

public class CategoriaSpesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@NotBlank(message = "L'inserimento del nome della categoria è obbligatorio")
	@Column(name = "nome", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "url-icona", nullable = false, unique = true)
	private String icona;
	
	@OneToMany(mappedBy = "categoriaSpesa")
	public List<Spesa> spese;

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

	public String getIcona() {
		return icona;
	}

	public void setIcona(String icona) {
		this.icona = icona;
	}

	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}
	
	

}
