package com.e_vangelio.service;

import java.util.List;

import com.e_vangelio.entity.Publicacion;

public interface PublicacionService {
	Publicacion crearPublicacion(Publicacion publicacion);
	List<Publicacion> obtenerPublicaciones();
	Publicacion obtenerPublicacionporId(Long id);

}
