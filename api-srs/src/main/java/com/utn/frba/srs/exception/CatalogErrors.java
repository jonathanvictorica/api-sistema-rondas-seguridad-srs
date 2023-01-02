package com.utn.frba.srs.exception;


public enum CatalogErrors {

    SUBSIDIARY_NOT_FOUND("Subsidiary not found."),

    ROUND_WITHOUT_CHECKPOINTS("Round without checkpoints"),


    ROUND_WITHOUT_ROUTES("Round without routes");

    final String message;

    CatalogErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return this.name();
    }
}
