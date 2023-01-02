package com.utn.frba.srs.config;


import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static Configuration getConfiguration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}