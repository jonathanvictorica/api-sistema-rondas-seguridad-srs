package com.utn.frba.srs.utils;

import com.utn.frba.srs.config.Configuration;
import com.utn.frba.srs.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class BaseAPI {

    public static Configuration configuration;


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

    }


    private static void determineLog() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        } else {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }


//    private static void invokeProductsFiles() {
//        given().queryParam("codEmpresa", "BR").header("Authorization", "Bearer " + BaseAPI.configuration.token()).
//                contentType(ContentType.JSON).
//                when().post("/api/v1/products");
//    }
//
//
//    private static void invokeTranslationFiles(String... languages) {
//        given().queryParam("codEmpresa", "BR").header("Authorization", "Bearer " + BaseAPI.configuration.token()).
//                contentType(ContentType.JSON).
//                body(
//                        FileLanguageRequest.builder()
//                                .files(Arrays.stream(languages).map(s ->
//                                        FileLanguageRequest.Language.builder().language(s).path(String.format(configuration.baseurlConfig() + "/translation_%s.properties", s)).build()
//                                ).collect(Collectors.toList()))
//                                .build()
//                ).
//                when().post("/api/v1/configurations/translation")
//                .andReturn().body();
//    }
//
//    private static void invokeCatalogFiles(String... paths) {
//        given().queryParam("codEmpresa", "BR").header("Authorization", "Bearer " + BaseAPI.configuration.token()).
//                contentType(ContentType.JSON).
//                body(FileCatalogRequest.builder().paths(List.of(paths)).build()).
//                when().post("/api/v1/configurations/catalog")
//                .andReturn().body();
//    }
//
//    private static Boolean verifyCatalog() {
//        var response = given().queryParam("codEmpresa", "BR")
//                .header("Authorization", "Bearer " + BaseAPI.configuration.token())
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/v1/configurations/catalog/verifyFill")
//                .andReturn().body().as(Map.class);
//
//        return (Boolean) response.get("status");
//    }

}
