package com.github.kadehar.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:local.properties"
})
public interface APIConfig extends Config {
    @Key("apiKey")
    String apiKey();
    @Key("apiBaseUrl")
    String apiBaseUrl();
}
