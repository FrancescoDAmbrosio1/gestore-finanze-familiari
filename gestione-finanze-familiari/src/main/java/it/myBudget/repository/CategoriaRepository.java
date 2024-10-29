package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
