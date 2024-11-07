package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.Mensile;

public interface MensileRepository extends JpaRepository<Mensile, Integer> {

}
