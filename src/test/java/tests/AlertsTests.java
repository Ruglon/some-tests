package tests;

import helper.ScreenshotExtension;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AlertsPage;
import pages.ElementsPage;
import pages.HomePage;

@ExtendWith(ScreenshotExtension.class)
public class AlertsTests extends BaseTest{
    private HomePage homePage;

    private AlertsPage alertPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        alertPage = new AlertsPage(driver);

    }

    @Test
    @Description("Go to Alerts, Frame & Windows page")
    public void openAlertsFrameWindowsPage(){
        homePage.acceptAgreement();
        int i = 0;
        homePage.choosePage("Alerts");
        alertPage.checkAlertsPage();
    }

    @Test
    @Description("Go to Alerts page")
    public void openAlertsPage(){
        homePage.acceptAgreement();
        int i = 0;
        homePage.choosePage("Alerts");
        alertPage.checkAlertsPage();
        alertPage.chooseOptionInList("Browser Windows");
        alertPage.openNewWindow("New Window Message");
    }
}
