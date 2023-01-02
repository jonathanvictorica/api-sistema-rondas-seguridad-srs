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
public class Checkpoint {

    @Id
    private String nfcCode;

    @Embedded
    private Ubiety ubiety;


    @ManyToOne
    @JoinColumn
    private Subsidiary subsidiary;
    private Boolean active = true;


}
