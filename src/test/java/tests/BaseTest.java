package tests;

import driverfactory.BrowserFactory;
import driverfactory.DriverFactory;
import helper.WaitHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.ConfigReader.baseConfig;

public class BaseTest {

    protected WebDriver driver;
    protected WaitHelper waitHelper;

    @BeforeEach
//    @ParameterizedTest
//    @EnumSource(BrowserFactory.class)
    public void preCondition() {

        driver = new DriverFactory().createInstance(baseConfig.browser());
        driver.manage().window().maximize();
        driver.get(baseConfig.url());
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }

}

