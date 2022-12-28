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
public class UsuarioSistema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "empresa_seguridad_ID")
	private EmpresaSeguridad empresaSeguridad;

	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String nroDocumento;
	private String mail = "";

	private String rolPrincipal;

	private String nickLogueo;
	private String password = "";
	private Integer cantidadIntentosFallidos = 0;
	private Boolean usuarioBloqueado = false;
	private Boolean usuarioActivo = true;


}
