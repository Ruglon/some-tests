package config;

import org.aeonbits.owner.Config;

/**
 * Reading keys from base.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", //entry point
        "file:src/test/resources/base.properties", //file path
})
public interface BaseConfig extends Config{

    @Key("browser")
    String browser();

    @Key("headless")
    String headless();

    @Key("target")
    String target();

    @Key("url.base")
    String url();

    @Key("url.api")
    String urlApi();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();
}
