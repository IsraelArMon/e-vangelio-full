package com.e_vangelio.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "creyentes")
public class Creyente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	private String usuario;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellidos;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String pais;
	
	@Column(nullable = false)
	private String lenguaje;
	
	@Column(nullable = false)
	private String religion;
	
	@OneToMany(mappedBy = "crente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Publicacion> publicaciones;
	
	@OneToMany(mappedBy = "crente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios;
}
