package com.e_vangelio.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String contenido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion = new Date();
	
	@ManyToOne
	@JoinColumn(name = "creyente_id", nullable = false)
	private Creyente crente;
	
	@ManyToOne
	@JoinColumn(name = "publicacion_id", nullable = false)
	private Publicacion publicacion;
}
