package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
