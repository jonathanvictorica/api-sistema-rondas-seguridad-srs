package com.utn.frba.srs.exception;

public class SRSException extends Exception {

	private static final long serialVersionUID = 1L;
	private String severidad;
	private String codigo;
	private String mensaje;

	public SRSException(String severidad, String codigo, String mensaje) {
		super();
		this.severidad = severidad;
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public SRSException(CatalogoErrores catalogoError) {
		this.severidad = catalogoError.getSeveridad();
		this.codigo = catalogoError.getCodigo();
		this.mensaje = catalogoError.getMensaje();
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
