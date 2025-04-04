package com.e_vangelio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_vangelio.entity.Creyente;
import com.e_vangelio.repository.CreyenteRepository;
import com.e_vangelio.service.CreyenteService;

@Service
public class CreyenteServiceImpl implements CreyenteService{
	
	@Autowired
	private CreyenteRepository creyenteRepository;
	
	@Override
	public Creyente registraCreyente(Creyente creyente) {
		return creyenteRepository.save(creyente);
	}
	
	@Override
	public Optional<Creyente> obtenerCreyentePorEmail(String email){
		return creyenteRepository.findByEmail(email);
	}

	@Override
	public List<Creyente> obtenerCreyentes() {
		// TODO Auto-generated method stub
		return creyenteRepository.findAll();
	}
}
