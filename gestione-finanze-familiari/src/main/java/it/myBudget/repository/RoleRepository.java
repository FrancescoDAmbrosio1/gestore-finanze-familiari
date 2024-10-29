package it.myBudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.myBudget.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
