package com.utn.frba.srs.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
public interface Configuration extends Config {

    @Key("api.base.path")
    String basePath();

    @Key("api.base.uri")
    String baseURI();

    @Key("api.port")
    int port();

    @Key("api.health.context")
    String health();

    @Key("log.all")
    boolean logAll();


    @Key("api.token")
    String token();
}
