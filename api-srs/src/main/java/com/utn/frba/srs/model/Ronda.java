package com.utn.frba.srs.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ronda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "sucursal_cliente_id")
	private SucursalCliente sucursalCliente;
	private String nombre;
	private String descripcion;

	@OneToMany
	private List<RondaCheckPoint> checkpoints;

	@OneToMany
	private List<RondaRuta> rutas;

	private Ubicacion ubicacionCentral;
	private String ubicacionZoom = "0";
	private Boolean activo = true;


}
