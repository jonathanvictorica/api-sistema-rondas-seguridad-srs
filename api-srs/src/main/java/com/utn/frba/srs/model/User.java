package com.utn.frba.srs.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "User", uniqueConstraints = {
		@UniqueConstraint(name = "uc_user_tipodocumento", columnNames = {"tipoDocumento", "nroDocumento"}),
		@UniqueConstraint(name = "uc_user_mail", columnNames = {"mail"})
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

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
	private Boolean usuarioActivo = true;



}
