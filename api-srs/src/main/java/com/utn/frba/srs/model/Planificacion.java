package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
	private LocalDateTime fechaHoraAsignacion;
	private LocalDateTime fechaHoraInicio;
	@ManyToOne
	@JoinColumn(name = "ronda_ejecucion_ID")
	private RondaEjecucion rondaEjecucion;
	private int minutosTolerancia;

	
	



}
