package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.Spesa;

public interface SpesaRepository extends JpaRepository<Spesa, Integer> {

}
