package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AlertsPage;
import pages.ElementsPage;
import pages.HomePage;

public class AlertsTests extends BaseTest{
    private HomePage homePage;

    private AlertsPage alertPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        alertPage = new AlertsPage(driver);

    }

    @Test
    @Description("Go to Alerts page")
    public void openAlertsPage(){
        homePage.acceptAgreement();
        int i = 0;
        homePage.choosePage("Elements");
        alertPage.checkAlertsPage();
    }
}
