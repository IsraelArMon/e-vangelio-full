package com.e_vangelio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_vangelio.entity.Creyente;
import com.e_vangelio.service.CreyenteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/creyentes")
@Tag(name = "Creyetentes", description = "Operaciones relacionadas con los creyentes")
public class CreyenteController {
	
	@Autowired
	private CreyenteService creyenteService;
	
	//localhost:8080/api/creyentes/signin
	@PostMapping("/signin")
	@Operation(summary = "Registrar un nuevo creyente")
	public Creyente registrarCreyente(@RequestBody Creyente creyente) {
		return creyenteService.registraCreyente(creyente);
	}
	
	//localhost:8080/api/creyentes/{email}
	@GetMapping("/{email}")
	@Operation(summary = "Obtener un creyente por email")
	public Creyente obtenerCreyentePorEmail(@PathVariable String email) {
		return creyenteService.obtenerCreyentePorEmail(email).orElse(null);
	}
	
	//localhost:8080/api/creyentes/
	@GetMapping("/")
	@Operation(summary = "Obtener todos los usuarios")
	public List<Creyente> obtenerCreyentes(){
		return creyenteService.obtenerCreyentes();
	}
}
