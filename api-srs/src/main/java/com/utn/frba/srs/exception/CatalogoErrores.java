package com.utn.frba.srs.exception;


import com.utn.frba.srs.constants.Constantes;

public enum CatalogoErrores {

	USUARIO_NO_EXISTE(Constantes.SEVERIDAD_WARNING, null, "El usuario no existe"), USUARIO_BLOQUEADO(Constantes.SEVERIDAD_ERROR, null, "El usuario esta bloqueado. Comuniquese con su administrador."),
	USUARIO_CONTRASENIA_INVALIDA(Constantes.SEVERIDAD_ERROR, null, "La clave es inv�lida"), TOKEN_NO_EXISTE(Constantes.SEVERIDAD_ERROR, "ERR_001", "El token no existe. Por favor invoque el servicio de autenticaci�n"),
	TOKEN_VENCIDO(Constantes.SEVERIDAD_ERROR, "ERR_001", "El token esta vencido. Por favor invoque el servicio de autenticaci�n"),
	CANAL_SIN_PERMISO_INVOCAR_SERVICIO_OPERACION(Constantes.SEVERIDAD_ERROR, "ERR_001", "El canal invocante no tiene permiso para invocar este servicio-operaci�n."),
	CHECKPOINT_SUELTO_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "No existe el checkpoint con el NFC indicado."),

	CLIENTE_EMPRESA_SEGURIDAD_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "El cliente no existe."), ESTADO_RONDA_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "El estado de la ronda no existe."),
	RONDA_SEGURIDAD_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La ronda de seguridad no existe."), RONDA_NOMBRE_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Existe una ronda con este nombre para este cliente. Por favor elija otro nombre."),
	COMPONENTENFC_NOMBRE_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "El componente NFC no existe."), USUARIO_CON_DOCUMENTO_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe un usuario con el tipo y n�mero de documento ingresado."),
	NICK_USUARIO_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe un usuario con ese nick."), ROL_USUARIO_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "El rol de usuario no existe."),
	CONTRASENIA_VACIA(Constantes.SEVERIDAD_ERROR, null, "Clave vacia."), EMPRESA_SEGURIDAD_EXISTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe una empresa de seguridad con el tipo y n�mero de documento ingresado."),
	EMPRESA_SEGURIDAD_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La empresa de seguridad no existe."), USUARIO_NO_PUEDE_ASIGNAR_RONDA(Constantes.SEVERIDAD_ERROR, null, "El usuario no puede asignar ejecuci�n de rondas."),
	USUARIO_NO_PUEDE_EJECUTAR_RONDA(Constantes.SEVERIDAD_ERROR, null, "El usuario no puede ejecutar rondas."), RONDA_ASIGNACION_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La asignaci�n de la ronda no existe."),
	CLIENTE_EMPRESA_SEGURIDAD_EXISTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe una empresa de seguridad con el tipo y n�mero de documento ingresado."),
	RONDA_EJECUCION_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La ejecuci�n de esta ronda no existe."), CHECKPOINT_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "No existe en la ronda un checkpoint con el NFC indicado."),
	CHECKPOINT_NO_MARCADO(Constantes.SEVERIDAD_ERROR, null, "El checkpoint no fue marcado."), EMPRESA_SEGURIDAD_DOCUMENTO_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe una empresa con el tipo y n�mero de documento ingresado."),
	USUARIO_CAMBIAR_CONTRASENIA(Constantes.SEVERIDAD_ERROR, null, "Debe setear una clave nueva."),
	CLIENTE_EMPRESA_SEGURIDAD_DOCUMENTO_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe un cliente con el tipo y n�mero de documento ingresado para esta empresa de seguridad."),
	SUCURSAL_EXISTENTE(Constantes.SEVERIDAD_ERROR, null, "Ya existe una sucursal con ese nombre para este cliente."), SUCURSAL_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La sucursal no existe."),
	RONDA_PLANIFICADA_EN_EJECUCION(Constantes.SEVERIDAD_ERROR, null, "La planificaci�n de esta ronda ya esta siendo ejecutada."), RONDA_EJECUCION_YA_FINALIZADA(Constantes.SEVERIDAD_ERROR, null, "La ronda ya fue finalizada."),
	RONDA_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "La ronda no existe."), ERROR_FORMATEO_DATE(Constantes.SEVERIDAD_ERROR, null, "Error de formateo de fecha"),
	DOMICILIO_MAL_INGRESADO(Constantes.SEVERIDAD_ERROR, null, "Error. No se ha podido encontrar una localizaci�n para el domicilio informado. Verifique el domicilio ingresado."),
	SERVICIO_GEOLOCALIZACION_FALLIDO(Constantes.SEVERIDAD_ERROR, null, "Fallo el servicio de google direcciones."),
	SUCURSAL_NO_ENCONTRADA_POR_GEOLOCALIZACION(Constantes.SEVERIDAD_ERROR, null, "No se encontro ninguna sucursal cercana a la ubicaci�n enviada."),
	RONDA_INCIDENTES_REVISAR(Constantes.SEVERIDAD_ERROR, null, "No se puede finalizar la ronda ya que existen incidentes abiertos."), INCIDENTE_NO_EXISTE(Constantes.SEVERIDAD_ERROR, null, "El incidente no existe."),
	RONDA_NO_INICIAR_POR_FECHA_HORA_INICIO(Constantes.SEVERIDAD_ERROR, "COD001", "No puede iniciar esta ronda, porque no es la hora de asignaci�n de la misma.");

	public String severidad, codigo, mensaje;

	private CatalogoErrores(String severidad, String codigo, String mensaje) {
		this.severidad = severidad;
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getSeveridad() {
		return severidad;
	}

	public void setSeveridad(String severidad) {
		this.severidad = severidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
