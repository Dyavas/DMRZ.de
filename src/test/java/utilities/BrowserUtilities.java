package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static utilities.Driver.driver;

public class BrowserUtilities {

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPageToLoad(long timeToWaitInSec) {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //it will scroll the screen until given element.
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }


    public static void mySendKeysMethod(WebElement element, String sendText) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My sendkeys method failed");
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(sendText);
    }
//    public s


    public static void myClickMethod(WebElement element) {
        //  WebElement webElement=Driver.getDriver().findElement(element);
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                withMessage("My click method failed");
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

}