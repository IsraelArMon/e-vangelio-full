package com.e_vangelio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_vangelio.entity.Creyente;

public interface CreyenteRepository extends JpaRepository<Creyente, Long> {
	
	Optional<Creyente> findByEmail(String email);
}
