package com.e_vangelio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_vangelio.entity.Publicacion;
import com.e_vangelio.service.PublicacionService;


@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

	@Autowired
	private PublicacionService publicacionService;
	
	@PostMapping("/")
	public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
		return publicacionService.crearPublicacion(publicacion);
	}
	
	@GetMapping("/")
	public List<Publicacion> obtenerPublicaciones(){
		return publicacionService.obtenerPublicaciones();
	}
	
	@GetMapping("/{id}")
	public Publicacion obtenerPublicacionPorId(@PathVariable Long id) {
		return publicacionService.obtenerPublicacionporId(id);
	}
}
