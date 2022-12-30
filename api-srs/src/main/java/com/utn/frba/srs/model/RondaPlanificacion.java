package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RondaPlanificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_id")
	private Ronda ronda;
	private String diaSemana;
	private LocalTime horaInicio;


	


}
