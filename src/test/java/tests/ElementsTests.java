package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ElementsPage;
import pages.HomePage;

public class ElementsTests extends BaseTest{

    private HomePage homePage;
    private ElementsPage elementsPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);

    }

    @Test
    @Description("Go to Elements page")
    public void openElementsPage() {
        homePage.acceptAgreement();
        int i = 0;
        homePage.choosePage("Elements");
        elementsPage.checkElementsPage();
    }
}
