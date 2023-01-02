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
public class RoundCheckpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Round round;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Checkpoint checkpoint;

    private Integer executionOrder;


}
