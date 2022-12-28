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
public class SucursalCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "cliente_empresa_seguridad_id")
	private ClienteEmpresaSeguridad clienteEmpresaSeguridad;

	@Embedded
	private Domicilio domicilio;
	private Boolean activo = true;


}
