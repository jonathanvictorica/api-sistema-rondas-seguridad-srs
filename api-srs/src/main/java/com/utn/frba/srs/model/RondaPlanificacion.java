package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
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
	private Time horaInicio;

	// Cuando es una fecha especifica la ronda
	private java.sql.Date fechaEjecucionEventual;

	// Minutos de tolerancia para que empiece la ronda
	private Integer minutosTolerancia ;


	// Datos de auditoria
	@ManyToOne
	@JoinColumn(name = "usuario_planificador_id")
	private UsuarioSistema usuarioPlanificador;
	private Date fechaHoraAsignacion;
	


}
