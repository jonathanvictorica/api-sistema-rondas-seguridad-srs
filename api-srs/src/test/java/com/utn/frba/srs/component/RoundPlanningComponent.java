package com.utn.frba.srs.component;

import com.utn.frba.srs.controller.RoundPlanningController;
import com.utn.frba.srs.controller.RoundPlanningControllerTest;
import com.utn.frba.srs.utils.BaseAPI;
import com.utn.frba.srs.utils.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RoundPlanningComponent {

    public static void createRoundPlanning(RoundPlanningController.RoundPlanningDto request) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(request).
                when().post(Endpoints.API_ROUND_PLANNING)
                .andReturn();
    }

    public static void updateRoundPlanning(RoundPlanningController.RoundPlanningDto request) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                body(request).
                when().put(Endpoints.API_ROUND_PLANNING)
                .andReturn();
    }

    public static void deleteRoundPlanning(Long roundPlanningId) {
        given().header("Authorization", "Bearer " + BaseAPI.configuration.token()).
                contentType(ContentType.JSON).
                pathParam("roundPlanningId", roundPlanningId).
                when().delete(Endpoints.API_ROUND_PLANNING + "/{roundPlanningId}")
                .andReturn().body();
    }

    public static RoundPlanningController.RoundPlanningDto findById(Long roundPlanningId) {
        return given()
                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
                .contentType(ContentType.JSON)
                .pathParam("roundPlanningId", roundPlanningId)
                .when()
                .get(Endpoints.API_ROUND_PLANNING + "/findById/{roundPlanningId}")
                .andReturn().body().as(RoundPlanningController.RoundPlanningDto.class);
    }


    public static RoundPlanningController.RoundPlanningListDto findByRoundId(Long roundId) {
        return given()
                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
                .contentType(ContentType.JSON)
                .pathParam("roundId", roundId)
                .when()
                .get(Endpoints.API_ROUND_PLANNING + "/findByRoundId/{roundId}")
                .andReturn().body().as(RoundPlanningController.RoundPlanningListDto.class);
    }

}
