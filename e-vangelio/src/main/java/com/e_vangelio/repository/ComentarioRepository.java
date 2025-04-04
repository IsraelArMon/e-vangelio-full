package com.e_vangelio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_vangelio.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

	List<Comentario> findByPublicacionId(Long publicacionId);

}
