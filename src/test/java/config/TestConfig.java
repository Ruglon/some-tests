package config;

import org.aeonbits.owner.Config;

/**
 * Reading keys from base.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", //entry point
        "file:src/test/resources/test.properties", //file path
})
public interface TestConfig extends Config{
}
