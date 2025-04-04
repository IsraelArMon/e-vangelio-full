package com.e_vangelio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentariosDTO {

	@NotBlank(message = "El contenido no puede estar vacio")
    private String contenido;
	
	@NotBlank(message = "El ID del creyente es requerido")
    private Long creyenteId;
	
	@NotBlank(message = "El ID de la publicacion es requerido")
    private Long publicacionId;
	
}
