package tests;

import helper.ScreenshotExtension;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AlertsPage;
import pages.HomePage;
import pages.skyscanner.BestLotsPage;
import pages.skyscanner.ScannerHomePage;

@ExtendWith(ScreenshotExtension.class)
public class RunTests extends BaseTest{
    private BestLotsPage bestLots;

    private ScannerHomePage homePage;

    @BeforeEach
    public void setUp() {
        homePage = new ScannerHomePage(driver);
        bestLots = new BestLotsPage(driver);

    }

    @Test
    @Description("Go to Scanner")
    public void openScannerPage() {
        homePage.acceptCookies();
        homePage.goToBestLots();
        bestLots.chooseDestination("Warsaw", "London");
    }
}
