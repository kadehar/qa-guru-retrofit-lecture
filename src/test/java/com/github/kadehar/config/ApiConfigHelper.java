package com.github.kadehar.config;

import org.aeonbits.owner.ConfigFactory;

public class ApiConfigHelper {
    private static final APIConfig apiConfig = ConfigFactory.create(
            APIConfig.class,
            System.getProperties()
    );

    public static String apiKey() { return apiConfig.apiKey(); }

    public static String apiBaseUrl() { return apiConfig.apiBaseUrl(); }
}
