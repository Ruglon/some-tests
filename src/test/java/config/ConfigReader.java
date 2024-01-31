package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Class for access to .properties
 */
public class ConfigReader {

    /**
     * Reading base.properties
     */
    public static final BaseConfig baseConfig = ConfigFactory.create(BaseConfig.class, System.getProperties());
    /**
     * Reading test.properties
     */
    public static final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
}
