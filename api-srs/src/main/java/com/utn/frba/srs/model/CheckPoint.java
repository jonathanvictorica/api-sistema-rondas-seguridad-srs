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
public class CheckPoint {

	@Id
	private String identificadorNFC;

	@Embedded
	private Ubicacion ubicacion;


	@ManyToOne
	@JoinColumn(name = "sucursal_cliente_id")
	private SucursalCliente sucursalCliente;
	private Boolean activo = true;






}
