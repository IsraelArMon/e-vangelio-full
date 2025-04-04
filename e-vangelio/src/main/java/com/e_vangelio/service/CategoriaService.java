package com.e_vangelio.service;

import java.util.List;

import com.e_vangelio.entity.Categoria;

public interface CategoriaService {
	Categoria crearCategoria(Categoria categoria);
	List<Categoria> obtenerCategorias();

}
