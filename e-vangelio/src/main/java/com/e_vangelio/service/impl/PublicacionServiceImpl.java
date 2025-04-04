package com.e_vangelio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_vangelio.entity.Publicacion;
import com.e_vangelio.repository.PublicacionRepository;
import com.e_vangelio.service.PublicacionService;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Override
	public Publicacion crearPublicacion(Publicacion publicacion) {
		// TODO Auto-generated method stub
		return publicacionRepository.save(publicacion);
	}

	@Override
	public List<Publicacion> obtenerPublicaciones() {
		// TODO Auto-generated method stub
		return publicacionRepository.findAll();
	}

	@Override
	public Publicacion obtenerPublicacionporId(Long id) {
		// TODO Auto-generated method stub
		return publicacionRepository.findById(id).orElse(null);
	}

	
}
