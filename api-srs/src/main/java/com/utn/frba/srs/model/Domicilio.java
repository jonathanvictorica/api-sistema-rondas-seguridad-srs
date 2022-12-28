package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Domicilio{

	private String nombreCalle;
	private String altura;
	private String departamento;
	private String piso;
	private String ciudad;
	private String partido;
	private String provincia;
	private String pais ;

	@Embedded
	private Ubicacion ubicacion;


}
