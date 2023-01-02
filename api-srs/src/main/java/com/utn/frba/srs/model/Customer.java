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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private SecurityCompany securityCompany;
    private String businessName;
    private String documentType;
    private String documentValue;
    @Embedded
    private Domicile domicile;
    private Boolean active = true;


}
