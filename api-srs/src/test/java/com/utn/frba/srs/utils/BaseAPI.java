package com.utn.frba.srs.utils;

import com.utn.frba.srs.component.GeneratorComponent;
import com.utn.frba.srs.config.Configuration;
import com.utn.frba.srs.config.ConfigurationManager;
import com.utn.frba.srs.controller.AuthController;
import com.utn.frba.srs.controller.CheckpointController;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class BaseAPI {

    public static Configuration configuration;

    public static String TOKEN="";


    @BeforeAll
    public static void init() {
        configuration = ConfigurationManager.getConfiguration();

        baseURI = configuration.baseURI();
        basePath = configuration.basePath();

        if (configuration.port() != 0) {
            port = configuration.port();
        }


        // solve the problem with big decimal assertions
        config = newConfig().
                jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL)).
                sslConfig(new SSLConfig().allowAllHostnames());

        RestAssured.useRelaxedHTTPSValidation();

        determineLog();
        login();
    }


    public static void login() {
       var responseAuth= given().contentType(ContentType.JSON).
                body(
                        new AuthController.AuthenticationRequest("admin","admin")
                ).
                when().post(Endpoints.API_LOGIN)
                .andReturn().as(AuthController.AuthenticationResponse.class);
       TOKEN=responseAuth.jwt();
    }

    private static void determineLog() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        } else {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }



}
