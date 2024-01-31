package pages;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    public AlertsPage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
