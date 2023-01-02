package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.CustomerController;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CustomerComponent {

    public static Long createCustomer(Long empresaSeguridadId, String nombre, String tipoDocumento, String numeroDocumento) {
        return given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(
                        new CustomerController.CustomerDto(
                                empresaSeguridadId,
                                nombre,
                                tipoDocumento,
                                numeroDocumento,
                                "altura",
                                "departamento",
                                "piso",
                                "ciudad",
                                "partido",
                                "provincia",
                                "latitud",
                                "longitud",
                                "longitud"
                        )
                ).
                when().post(Endpoints.API_CUSTOMER)
                .andReturn().body().as(Long.class);
    }

    public static void deleteCustomer(Long customerId) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                pathParam("customerId", customerId)
                .when().delete(Endpoints.API_CUSTOMER)
                .andReturn().body();
    }

}
