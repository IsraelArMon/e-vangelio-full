package com.e_vangelio.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.e_vangelio.dto.ComentariosDTO;
import com.e_vangelio.entity.Comentario;
import com.e_vangelio.service.ComentarioService;

import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	private static final Logger log = LoggerFactory.getLogger(ComentarioController.class);
	
	@PostMapping("/comentar")
	public ResponseEntity<Comentario> crearComentario(@RequestBody ComentariosDTO comentarioDTO) {
	    log.debug("Creando comentario: {}", comentarioDTO);
	    try {
	        Comentario resultado = comentarioService.crearComentario(comentarioDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	    } catch (IllegalArgumentException e) {
	        log.error("Error al crear comentario: {}", e.getMessage());
	        return ResponseEntity.badRequest().build();
	    }
	}
	
	@DeleteMapping("/comentario/{id}")
	public ResponseEntity<String> eliminarComentario(@PathVariable Long id){
		try {
			comentarioService.eliminarComentario(id);
			return ResponseEntity.ok("Comentario borrado Excitosamente");
		
		}catch(EntityNotFoundException E) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/publicacion/{publicacionId}")
	public List<Comentario> obtenerComentariosPorPublicacion(@PathVariable Long publicacionId){
		return comentarioService.obtenerComentariosPorPublicacion(publicacionId);
	}
	
	/*@PostMapping("/comentar")
	public ResponseEntity<Comentario> crearComentario(HttpServletRequest request) {
	    try {
	        // Leer el cuerpo de la solicitud manualmente
	        String json = request.getReader().lines().collect(Collectors.joining());
	        log.info("JSON crudo recibido: {}", json);
	        
	        // Convertir manualmente
	        ObjectMapper mapper = new ObjectMapper();
	        ComentariosDTO comentarioDTO = mapper.readValue(json, ComentariosDTO.class);
		    Comentario comentarioCreado = comentarioService.crearComentario(comentarioDTO);
			return new ResponseEntity<>(comentarioCreado, HttpStatus.CREATED);   
	        // Resto de tu lógica...
	    } catch (IOException e) {
	        throw new RuntimeException("Error procesando el JSON", e);
	    }
	}*/
	
	
}
