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
public class RondaRuta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ronda_ID")
	private Ronda ronda;
	private int ordenCaminoRuta;

	@Embedded
	private Ubicacion ubicacion;
	
	

	
	
}
