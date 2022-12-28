package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_ID")
	private Ronda ronda;
	private Date fechaHoraAsignacion;
	private Date fechaHoraInicio;
	@ManyToOne
	@JoinColumn(name = "ronda_ejecucion_ID")
	private RondaEjecucion rondaEjecucion;
	private int minutosTolerancia;

	
	



}
