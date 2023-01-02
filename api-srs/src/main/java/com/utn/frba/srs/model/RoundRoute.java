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
public class RoundRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Round round;

    private int ordenCaminoRuta;

    @Embedded
    private Ubiety ubiety;


}
