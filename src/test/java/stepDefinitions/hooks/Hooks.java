package stepDefinitions.hooks;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.File;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if ((scenario.isFailed())) {
            final byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName() + "_screenshot");
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            //full path to the screenshot location
            String target = System.getProperty("user,dir") + "/test.feature-output/Screenshots/" + source.getName() + ".png";
            File finalDestination = new File(target);
        }
        BrowserUtilities.waitFor(3);
        Driver.closeDriver();
    }
}
