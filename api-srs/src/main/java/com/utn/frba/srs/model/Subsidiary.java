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
public class Subsidiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn
    private Customer customer;

    @Embedded
    private Domicile domicile;
    private Boolean active;


}
