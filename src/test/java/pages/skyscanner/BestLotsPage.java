package pages.skyscanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BestLotsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'App_flights')]//div[@id='fsc-origin-search-0-location-selector']")
    private WebElement destinationOriginFirst;

    @FindBy(xpath = "//div[contains(@class, 'App_flights')]//div[@id='fsc-destination-search-0-location-selector']")
    private WebElement destinationDestinationFirst;

    @FindBy(xpath = "//div[contains(@class, 'App_flights')]//div[@id='fsc-origin-search-1-location-selector']")
    private WebElement destinationOriginSecond;

    @FindBy(xpath = "//div[contains(@class, 'App_flights')]//div[@id='fsc-destination-search-1-location-selector']")
    private WebElement destinationDestinationSecond;

    @FindBy(xpath = "//div[contains(@class, 'leg-date')]//button[@id='fsc-leg-date-0-fsc-datepicker-button']")
    private WebElement dateOfDeparture;

    @FindBy(xpath = "//div[contains(@class, 'leg-date')]//button[@id='fsc-leg-date-1-fsc-datepicker-button']")
    private WebElement dateOfReturn;

    List<WebElement> destinationList;


    public void chooseDestination(String from, String to){
        destinationOriginFirst.sendKeys(from);
        destinationDestinationFirst.sendKeys(to);
        destinationOriginSecond.sendKeys(to);
        destinationDestinationSecond.sendKeys(from);
    }

    public void chooseDates(int date){

    }

    public BestLotsPage(WebDriver driver) {
        // Using driver from DriverFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
