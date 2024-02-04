package helper;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotExtension implements TestWatcher {

    private final WebDriver driver;

    public ScreenshotExtension(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testClassName = context.getTestClass().get().getSimpleName();
            String testMethodName = context.getTestMethod().get().getName();
            Path destinationPath = Paths.get("screenshots", testClassName + "_" + testMethodName + ".png");
            Files.copy(screenshotFile.toPath(), destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
