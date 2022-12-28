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
public class ClienteEmpresaSeguridad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "empresa_seguridad_ID")
	private EmpresaSeguridad empresaSeguridad;
	private String razonSocial;
	private String tipoDocumento;
	private String nroDocumento;
	@Embedded
	private Domicilio domicilio;
	private Boolean activo = true;






}
