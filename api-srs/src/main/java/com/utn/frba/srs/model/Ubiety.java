package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Ubiety {
    private String latitude;
    private String longitude;


}
