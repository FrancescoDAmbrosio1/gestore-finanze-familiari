package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.CategoriaSpesa;

public interface CategoriaSpesaRepository extends JpaRepository<CategoriaSpesa, Integer> {

}
