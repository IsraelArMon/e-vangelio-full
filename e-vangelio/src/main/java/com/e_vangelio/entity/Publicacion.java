package com.e_vangelio.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "publicaciones")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String contenido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion = new Date();
	
	@ManyToOne
	@JoinColumn(name = "creyente_id", nullable = false)
	private Creyente crente;
	
	@OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios;
	
	@ManyToMany
	@JoinTable(
		name = "publicacion_categoria",
		joinColumns = @JoinColumn(name = "publicacion_id"),
		inverseJoinColumns =  @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias;
	
}
