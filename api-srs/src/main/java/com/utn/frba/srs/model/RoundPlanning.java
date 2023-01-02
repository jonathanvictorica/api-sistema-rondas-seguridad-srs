package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundPlanning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn
	private Round round;
	private String diaSemana;
	private LocalTime horaInicio;


	


}
