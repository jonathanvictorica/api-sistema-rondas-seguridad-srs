package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.CompanySecurityController;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CompanySecurityComponent {

    public static void deleteCompanySecurity(Long companySecurityId) {
        given().header("Authorization", "Bearer " + BaseAPI.TOKEN).
                contentType(ContentType.JSON).
                pathParam("companySecurityId", companySecurityId)
                .when().delete(Endpoints.API_COMPANY_SECURITY)
                .andReturn().body();
    }

    public static Long createCompanySecurity(String nombre, String tipoDocumento, String numeroDocumento) {
        return given().header("Authorization", "Bearer " + BaseAPI.TOKEN).
                contentType(ContentType.JSON).
                body(
                        new CompanySecurityController.CompanySecurityDto(
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
                when().post(Endpoints.API_COMPANY_SECURITY)
                .andReturn().body().as(Long.class);
    }
}
