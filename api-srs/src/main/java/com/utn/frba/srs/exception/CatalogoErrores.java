package com.utn.frba.srs.exception;


public enum CatalogoErrores {

	USUARIO_NO_EXISTE("El usuario no existe"),
	CLIENTE_EMPRESA_SEGURIDAD_NO_EXISTE("El cliente no existe."),
	RONDA_NOMBRE_EXISTENTE("Existe una ronda con este nombre para este cliente. Por favor elija otro nombre."),
	COMPONENTENFC_NOMBRE_EXISTENTE("El componente NFC no existe."),
	USUARIO_CON_DOCUMENTO_EXISTENTE("Ya existe un usuario con el tipo y n�mero de documento ingresado."),
	EMPRESA_SEGURIDAD_EXISTE("Ya existe una empresa de seguridad con el tipo y n�mero de documento ingresado."),
	EMPRESA_SEGURIDAD_NO_EXISTE("La empresa de seguridad no existe."),
	USUARIO_NO_PUEDE_EJECUTAR_RONDA("El usuario no puede ejecutar rondas."),
	CLIENTE_EMPRESA_SEGURIDAD_EXISTE("Ya existe una empresa de seguridad con el tipo y n�mero de documento ingresado."),
	RONDA_EJECUCION_NO_EXISTE("La ejecuci�n de esta ronda no existe."),
	CHECKPOINT_NO_EXISTE("No existe en la ronda un checkpoint con el NFC indicado."),
	EMPRESA_SEGURIDAD_DOCUMENTO_EXISTENTE("Ya existe una empresa con el tipo y n�mero de documento ingresado."),
	CLIENTE_EMPRESA_SEGURIDAD_DOCUMENTO_EXISTENTE("Ya existe un cliente con el tipo y n�mero de documento ingresado para esta empresa de seguridad."),
	SUCURSAL_EXISTENTE("Ya existe una sucursal con ese nombre para este cliente."),
	SUCURSAL_NO_EXISTE("La sucursal no existe."),
	RONDA_PLANIFICADA_EN_EJECUCION("La planificaci�n de esta ronda ya esta siendo ejecutada."),
	RONDA_EJECUCION_YA_FINALIZADA("La ronda ya fue finalizada."),
	RONDA_NO_EXISTE("La ronda no existe."),
	RONDA_SIN_CHECKPOINTS("Ronda sin checkpoints" ),
	RONDA_SIN_RUTAS("Ronda sin rutas" );

	public String mensaje;

	CatalogoErrores(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	public String getCodigo(){
		return this.name();
	}
}
