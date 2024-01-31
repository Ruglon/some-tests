package pages;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    public FormsPage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
