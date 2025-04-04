package com.e_vangelio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_vangelio.dto.ComentariosDTO;
import com.e_vangelio.entity.Comentario;
import com.e_vangelio.entity.Creyente;
import com.e_vangelio.entity.Publicacion;
import com.e_vangelio.exceptions.ResourceNotFoundException;
import com.e_vangelio.repository.ComentarioRepository;
import com.e_vangelio.repository.CreyenteRepository;
import com.e_vangelio.repository.PublicacionRepository;
import com.e_vangelio.service.ComentarioService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private CreyenteRepository creyenteRepository;
	
	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Override
	public Comentario crearComentario(ComentariosDTO comentarioDTO) {
		// TODO Auto-generated method stub
		//validar si el creyente existe
		Creyente creyente = creyenteRepository.findById(comentarioDTO.getCreyenteId())
				.orElseThrow(() -> new ResourceNotFoundException("Creyente no encontrado " + comentarioDTO.getCreyenteId()));
		//validar si la publicacion existe
		Publicacion publicacion = publicacionRepository.findById(comentarioDTO.getPublicacionId())
				.orElseThrow(() -> new ResourceNotFoundException("Publicacion no encontrada " + comentarioDTO.getPublicacionId()));
		
		if(comentarioDTO.getContenido() == null || comentarioDTO.getContenido().trim().isEmpty()) {
			throw new IllegalArgumentException("ingresa un comentario...");
		}
		//Crear comentario 
		Comentario comentario = new Comentario();
		comentario.setContenido(comentarioDTO.getContenido());
		comentario.setCrente(creyente);
		comentario.setPublicacion(publicacion);
		return comentarioRepository.save(comentario);
	}

	@Override
	public List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId) {
		// TODO Auto-generated method stub
		return comentarioRepository.findByPublicacionId(publicacionId);
	}

	@Override
	public void eliminarComentario(Long id) {
		// TODO Auto-generated method stub
		Comentario comentario = comentarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Comentario no encontrado"));
		
		comentarioRepository.delete(comentario);
	}
	
}
