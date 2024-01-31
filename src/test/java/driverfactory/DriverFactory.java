package driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import static config.ConfigReader.baseConfig;

public class DriverFactory {
    private static final Logger logger = Logger.getLogger("com.vital");

    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(baseConfig.target().toUpperCase());
        int i = 0;
        switch (target) {
            case LOCAL:
                return BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
            case REMOTE:
                return createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
            default:
                throw new IllegalArgumentException("Unsupported target: " + target);
        }
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", baseConfig.gridUrl(), baseConfig.gridPort());

            remoteWebDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), capability);
        } catch (java.net.MalformedURLException e) {
            logger.log(Level.SEVERE, "Grid URL is invalid or Grid is not available");
            logger.log(Level.SEVERE, String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
