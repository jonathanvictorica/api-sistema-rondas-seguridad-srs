package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Ubicacion {
	private String latitud;
	private String longitud;


}
