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
public class RondaEjecucionEvento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime fechaHoraEvento;
	@ManyToOne
	@JoinColumn(name = "ronda_ejecucion_ID")
	private RondaEjecucion rondaEjecucion;

	private String tipoEvento;

	private String checkpointIdentificadorNFC = "";

	@Embedded
	private Ubicacion ubicacion;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User usuario;




}
