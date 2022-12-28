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

	@ManyToOne
	@JoinColumn(name = "estado_ronda_codigo")
	private EstadoRonda estadoRonda;


	@OneToMany
	private List<RondaCheckPoint> checkpoints;

	@OneToMany
	private List<RondaRuta> rutas;


	private Ubicacion ubicacion;
	private String ubicacionZoom = "0";
	private Integer tiempoRecorridoRonda;


	private Boolean activo = true;


}
