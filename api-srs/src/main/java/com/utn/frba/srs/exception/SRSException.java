package com.utn.frba.srs.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SRSException extends Exception {

    private final String code;

    public SRSException(CatalogoErrores catalogoError) {
        super(catalogoError.getMensaje());
        this.code = catalogoError.getCodigo();

    }



}
