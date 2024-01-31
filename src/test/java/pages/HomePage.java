package pages;

import helper.ActionsHelper;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='home-banner']")
    private WebElement homeBanner;

    @FindBy(xpath = "//div[@id='app']//img[@src='/images/Toolsqa.jpg']")
    private WebElement logoButton;

    @FindBy(xpath = "//div[@class='fc-footer-buttons-container']" +
            "//button[contains(@class, 'fc-cta-consent fc-primary-button')]")
    private WebElement agreementButton;

//div[@class='category-cards']//div[@class='card-body']//h5[contains(text(), 'Elements')]/parent::*/following-sibling::div[contains(@class, 'avatar')]

    public HomePage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAgreement(){
        WaitHelper.clickIfVisible(agreementButton, driver, 15);
    }


    public void choosePage(String cardName){
        String messageActual = String.format("//div[@class='category-cards']//div[@class='card-body']" +
                "//h5[contains(text(), '%s')]/parent::*", cardName);

        WebElement card  = WaitHelper.waitForElementToBeVisibleByLocator(By.xpath(messageActual), driver, 15);
        ActionsHelper.scrollToElement(driver, card);
        card.click();

            switch (cardName) {
                case "Elements":
                    goToElementsPage();
                    break;
                case "Forms":
                    goToAlertsPage();
                    break;
                case "Alerts, Frame & Windows":
                    goToFormsPage();
                default:
                    throw new IllegalArgumentException("No such card page: " + cardName);
            }
    }

    public WebElement getAgreementButton() {
        return agreementButton;
    }


    public ElementsPage goToElementsPage() {
        return new ElementsPage(driver);
    }

    public AlertsPage goToAlertsPage() {
        return new AlertsPage(driver);
    }

    public FormsPage goToFormsPage() {
        return new FormsPage(driver);
    }
}
