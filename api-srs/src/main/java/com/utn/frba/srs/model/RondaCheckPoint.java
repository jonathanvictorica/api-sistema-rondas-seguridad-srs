package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RondaCheckPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_ID")
	private Ronda ronda;
	@ManyToOne
	@JoinColumn(name = "check_point_identificador_nfc")
	private CheckPoint checkPoint;

	private Integer ordenEjecucion;

	


}
