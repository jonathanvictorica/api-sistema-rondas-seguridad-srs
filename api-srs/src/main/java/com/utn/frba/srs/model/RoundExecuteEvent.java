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
public class RoundExecuteEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime dateTimeEvent;
	@ManyToOne
	@JoinColumn
	private RoundExecute roundExecute;

	private String eventType;

	private String nfcCode;

	@Embedded
	private Ubiety ubiety;

	@ManyToOne
	@JoinColumn
	private User user;




}
