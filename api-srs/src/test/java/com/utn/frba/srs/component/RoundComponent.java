package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.RoundController;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RoundComponent {

    public static Long createRound(Long subsidiaryId,String roundName,
                                   List<RoundController.RoundCheckPointDto> checkpoints,
                                   List<RoundController.RoundRouteDto> rutas) {
        return given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(
                        new RoundController.RoundDto(null,subsidiaryId,
                                roundName,
                                "descripcion",
                                checkpoints,
                                rutas)
                ).
                when().post(Endpoints.API_ROUND)
                .andReturn().as(Long.class);
    }


    public static void deleteRound(Long roundId) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                pathParam("roundId", roundId).
                when().delete(Endpoints.API_ROUND + "/{roundId}")
                .andReturn().body();
    }

    public static RoundController.RoundReduceDto findById(Long roundId) {
        return given()
                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
                .contentType(ContentType.JSON)
                .pathParam("roundId", roundId)
                .when()
                .get(Endpoints.API_ROUND + "/findById/{roundId}")
                .andReturn().body().as(RoundController.RoundReduceDto.class);
    }

    public static void updateRound(Long roundId,Long subsidiaryId,String roundName,
                                   List<RoundController.RoundCheckPointDto> checkpoints,
                                   List<RoundController.RoundRouteDto> rutas) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(
                        new RoundController.RoundDto(roundId,subsidiaryId,
                                roundName,
                                "descripcion",
                                checkpoints,
                                rutas)
                ).
                when().put(Endpoints.API_ROUND)
                .andReturn();

    }
}
