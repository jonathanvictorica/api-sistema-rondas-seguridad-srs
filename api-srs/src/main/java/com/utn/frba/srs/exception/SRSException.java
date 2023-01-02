package com.utn.frba.srs.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SRSException extends Exception {

    private final String code;

    public SRSException(CatalogErrors catalogoError) {
        super(catalogoError.getMessage());
        this.code = catalogoError.getCode();

    }


}
