package com.e_vangelio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_vangelio.entity.Categoria;
import com.e_vangelio.repository.CategoriaRepository;
import com.e_vangelio.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}
}
