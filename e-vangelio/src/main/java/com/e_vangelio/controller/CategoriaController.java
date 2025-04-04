package com.e_vangelio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.e_vangelio.entity.Categoria;
import com.e_vangelio.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/")
	public List<Categoria> obtenerCategorias(){
		return categoriaService.obtenerCategorias();
	}
}
