package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.SubsidiaryController;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SubsidiaryComponent {

    public static Long createSubsidary(Long customerId, String sucursalName) {
        return given().header("Authorization", "Bearer " + BaseAPI.TOKEN).
                contentType(ContentType.JSON).
                body(
                        new SubsidiaryController.SubsidiaryDto(
                                null,
                                sucursalName,
                                "descripcion",
                                "nombreCalle",
                                "altura",
                                "departamento",
                                "piso",
                                "ciudad",
                                "partido",
                                "provincia",
                                "latitud",
                                "longitud",
                                customerId
                        )
                ).
                when().post(Endpoints.API_SUBSIDIARY)
                .andReturn().body().as(Long.class);


    }

    public static void deleteSubsidary(Long subsidiaryId) {
        given().header("Authorization", "Bearer " + BaseAPI.TOKEN).
                contentType(ContentType.JSON).
                pathParam("subsidiaryId", subsidiaryId)
                .when().delete(Endpoints.API_SUBSIDIARY)
                .andReturn().body();
    }
}
