package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.CheckpointController;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CheckpointComponent {

    public static void createCheckpoint(Long subsidiaryId, String identificadorNFC) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(
                        new CheckpointController.CheckpointDto(identificadorNFC,
                                GeneratorComponent.latitud(), GeneratorComponent.longitud(), subsidiaryId)
                ).
                when().post(Endpoints.API_CHECKPOINT)
                .andReturn();
    }

    public static void updateCheckpoint(CheckpointController.CheckpointDto request) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(request).
                when().put(Endpoints.API_CHECKPOINT)
                .andReturn();
    }

    public static void deleteCheckpoint(String nfcCode) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                pathParam("nfcCode", nfcCode).
                when().delete(Endpoints.API_CHECKPOINT + "/{nfcCode}")
                .andReturn().body();
    }

    public static CheckpointController.CheckpointReduceDto findById(String nfc) {
        return given()
                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
                .contentType(ContentType.JSON)
                .pathParam("nfcCode", nfc)
                .when()
                .get(Endpoints.API_CHECKPOINT + "/findById/{nfcCode}")
                .andReturn().body().as(CheckpointController.CheckpointReduceDto.class);
    }


    public static CheckpointController.CheckpointReduceListDto findBySubsidiary(Long subsidiaryId) {
        return given()
                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
                .contentType(ContentType.JSON)
                .pathParam("subsidiaryId", subsidiaryId)
                .when()
                .get(Endpoints.API_CHECKPOINT + "/findBySubsidiary/{subsidiaryId}")
                .andReturn().body().as(CheckpointController.CheckpointReduceListDto.class);
    }

}
