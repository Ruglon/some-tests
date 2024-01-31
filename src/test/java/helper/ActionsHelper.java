package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {

    public static JavascriptExecutor js;
    public static String accessToken;
    public static void scrollToElement(WebDriver driver, WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElementWithActions(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to accept");
        }

    }

    public void dismissAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to dismiss");
        }
    }

    public void sendTextToAlert(String text, WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to send text to");
        }
    }

    public String getItemFromLocalStorage(WebDriver driver)
    {
        js = ((JavascriptExecutor)driver);
        return accessToken = "Bearer " + (String) js.executeScript("return window.localStorage.getItem('CognitoIdentityServiceProvider.s89f9fautjh566gcpbe9dfkik.peter.ilimovichfrancesco.idToken')");
    }
}
