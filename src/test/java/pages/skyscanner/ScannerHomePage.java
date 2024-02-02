package pages.skyscanner;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.AlertsPage;

public class ScannerHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'CookieBanner')]//button[@id='acceptCookieButton']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//div[contains(@class, 'Destination')]")
    private WebElement destinationField;

    @FindBy(xpath = "//div[contains(@class, 'DestinationSearchControlsGroup')]//span[contains(text(), 'Wyszukiwanie')]")
    private WebElement destinationDropDownAll;


    public ScannerHomePage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies(){
        WaitHelper.clickIfVisible(acceptCookies, driver, 15);
    }

    public void chooseDestination(String destination){
        WaitHelper.waitForElementToBeVisible(destinationField, driver, 10);
        destinationField.sendKeys(destination);
    }

    public void goToBestLots(){
        destinationField.click();
        WaitHelper.waitForElementToBeVisible(destinationDropDownAll, driver, 10);
        destinationDropDownAll.click();
    }

    public BestLotsPage goToAlertsPage() {
        return new BestLotsPage(driver);
    }

}
