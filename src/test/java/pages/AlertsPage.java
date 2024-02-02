package pages;

import helper.ActionsHelper;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AlertsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'playgound-header')]//div[contains(text(), 'Alerts')]")
    private WebElement alertsHeader;

    public AlertsPage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseOptionInList(String option){
        String messageActual = String.format("//div[contains(@class, 'element-list')]" +
                "//li//span[contains(text(), '%s')]", option);

        //div[contains(@class, 'element-list')]//li//span[contains(text(), 'Browser Windows')]
        WebElement card  = WaitHelper.waitForElementToBeVisibleByLocator(By.xpath(messageActual), driver, 15);
        ActionsHelper.scrollToElement(driver, card);
        card.click();
    }

    /**
     * Handle different type of opened new windows and tabs
     */

    public void openNewWindow(String buttonName){
        String messageActual = String.format("//div[@id='browserWindows']" +
                "//button[contains(text(), '%s')]", buttonName);
        String originalWindow = driver.getWindowHandle();
        String text;
        WebElement card  = WaitHelper.waitForElementToBeVisibleByLocator(By.xpath(messageActual), driver, 15);
        ActionsHelper.scrollToElement(driver, card);

        switch (buttonName) {
            case "New Window Message":
                assert card != null;
                card.click();
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!originalWindow.contentEquals(windowHandle)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }
//                WaitHelper.waitForElementToBeVisibleByLocator(By.xpath("//*[contains(text(), " +
//                        "'Knowledge increases')]"), driver, 15);
//                driver.findElement(By.xpath("//*[contains(text(), 'Knowledge increases')]"));

                driver.close(); // Close the new window
                driver.switchTo().window(originalWindow);
                break;
            case "New Window":
                card.click();
                break;
            case "New Tab":
                card.click();
            default:
                throw new IllegalArgumentException("No such button: " + buttonName);
        }
    }


    public void checkAlertsPage() {
        WaitHelper.waitForElementToBeVisible(alertsHeader, driver,15);
    }
}
