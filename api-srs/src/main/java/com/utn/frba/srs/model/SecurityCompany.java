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
public class SecurityCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String businessName;
	private String documentType;
	private String documentValue;
	private Domicile domicile;
	private Boolean active;




}
