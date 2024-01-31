package pages;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    @FindBy(xpath = "//div[contains(@class, 'playgound-header')]//div[contains(text(), 'Elements')]")
    private WebElement elementsHeader;

    public ElementsPage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkElementsPage() {
        WaitHelper.waitForElementToBeVisible(elementsHeader, driver,15);
    }

}
