package com.e_vangelio.service;

import java.util.List;

import com.e_vangelio.dto.ComentariosDTO;
import com.e_vangelio.entity.Comentario;

public interface ComentarioService {
	
	Comentario crearComentario(ComentariosDTO comentarioDTO);
	List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId);
	void eliminarComentario(Long id);

}
