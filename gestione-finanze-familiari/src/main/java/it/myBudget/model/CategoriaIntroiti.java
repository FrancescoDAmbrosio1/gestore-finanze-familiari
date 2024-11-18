package it.myBudget.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "categoria_introiti")

public class CategoriaIntroiti {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@NotBlank(message = "L'inserimento del Nome è obbligatorio")
@Column(name = "nome", nullable = false, unique = true)
private String nome;

@NotBlank(message = "L'inserimento dell'icona è obbligatorio")
@Column(name = "url_icona", nullable = false, unique = true)
private String iconaUrlIntroiti;

@Column(name = "note")
private String note;

@OneToMany(mappedBy = "categoriaIntroito")
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

public String getIconaUrlIntroiti() {
	return iconaUrlIntroiti;
}

public void setIconaUrlIntroiti(String iconaUrlIntroiti) {
	this.iconaUrlIntroiti = iconaUrlIntroiti;
}

public List<Introito> getIntroiti() {
	return introiti;
}

public void setIntroiti(List<Introito> introiti) {
	this.introiti = introiti;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}



}
