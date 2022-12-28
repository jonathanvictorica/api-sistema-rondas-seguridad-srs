package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RondaEjecucion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_id")
	private Ronda ronda;

	@OneToMany
	private List<RondaEjecucionEvento> eventos;
	private String detalleEjecucion = null;

	// En caso que un supervisor tenga que revisar la ronda se llenan estos
	// campos
	@ManyToOne
	@JoinColumn(name = "usuario_revision_id")
	private UsuarioSistema usuarioRevision;
	private String comentarioRevision;
	private Date fechaHoraRevision;

	private Boolean indicadorRondaEjecucionFallida = false;
	private Boolean indicadorRondaIncidentes = false;
	private Boolean indicadorRondaFinalizada =false;
	private Boolean indicadorRondaEjecutada = true;
	@ManyToOne
	@JoinColumn(name = "estado_codigo")
	private EstadoRondaEjecucion estado;


	
	

}
