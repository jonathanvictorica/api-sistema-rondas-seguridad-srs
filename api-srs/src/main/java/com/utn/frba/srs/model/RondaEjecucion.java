package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
	private User usuarioRevision;
	private String comentarioRevision;
	private LocalDateTime fechaHoraRevision;


	private String estado;


	
	

}
