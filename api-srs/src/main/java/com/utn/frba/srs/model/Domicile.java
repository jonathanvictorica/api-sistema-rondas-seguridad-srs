package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Domicile {

    private String streetName;
    private String streetNumber;
    private String apartment;
    private String flat;
    private String city;
    private String party;
    private String province;

    @Embedded
    private Ubiety ubiety;


}
