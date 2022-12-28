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
public class RondaEjecucionEvento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_ejecucion_ID")
	private RondaEjecucion rondaEjecucion;
	@ManyToOne
	@JoinColumn(name = "tipo_evento_codigo")
	private TipoEventoRonda tipoEvento;

	private String checkpointIdentificadorNFC = "";

	@Embedded
	private Ubicacion ubicacion;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSistema usuario;
	private Date fechaHoraEvento;
	private String comentarioVigilante;


	// En caso que un supervisor tenga que revisar la ronda se llenan estos campos
	@ManyToOne
	@JoinColumn(name = "usuario_revision_id")
	private UsuarioSistema usuarioRevision;
	private String comentarioRevision;
	private Date fechaHoraRevision;

	private Boolean isResuelto;

}
