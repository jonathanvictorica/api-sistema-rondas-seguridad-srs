package com.utn.frba.srs.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn
	private Subsidiary subsidiary;
	private String name;
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<RoundCheckpoint> checkpoints;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<RoundRoute> routes;

	private Boolean active = true;


}
