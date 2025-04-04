package com.e_vangelio.service;

import java.util.List;
import java.util.Optional;

import com.e_vangelio.entity.Creyente;

public interface CreyenteService {
	
	Creyente registraCreyente(Creyente creyente);
	Optional<Creyente> obtenerCreyentePorEmail(String email);
	List<Creyente> obtenerCreyentes();
	
}
