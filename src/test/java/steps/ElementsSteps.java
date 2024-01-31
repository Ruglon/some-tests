package steps;

import driverfactory.DriverFactory;
import helper.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ElementsPage;
import pages.HomePage;

import static config.ConfigReader.baseConfig;

public class ElementsSteps {

    protected WebDriver driver;
    protected WaitHelper waitHelper;
    private HomePage homePage;
    private ElementsPage elementsPage;

    @Given("^Open portal$")
    public void goToPortal() {
        driver = new DriverFactory().createInstance(baseConfig.browser());
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        driver.manage().window().maximize();
        driver.get(baseConfig.url());
    }

    @Then("Go to {string} page")
    public void goToElements(String cardName) {
        homePage.acceptAgreement();
        homePage.choosePage(cardName);
        elementsPage.checkElementsPage();
    }

    @Given("Close browsers")
    public void quitBrowser() {
        try {
            driver.close();
            driver.quit();
        } catch (NullPointerException ignored) {
            System.out.println("Ignored NullPointerException on logout");
        }
    }
}
