package com.utn.frba.srs.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoEventoRonda  {
	@Id
	private String codigo;
	private String nombre;
	private String descripcion;

}
