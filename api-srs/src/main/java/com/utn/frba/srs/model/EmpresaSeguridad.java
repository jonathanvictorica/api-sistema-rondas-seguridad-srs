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
public class EmpresaSeguridad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String razonSocial;
	private String tipoDocumento;
	private String nroDocumento;
	private Domicilio domicilio;
	private Boolean activo = true;




}
