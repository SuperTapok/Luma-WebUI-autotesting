package selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    /**
     * helper class
     */

    protected WebDriver driver;
    protected Actions actions;

    public BasePage (WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    protected void waitUntilVisibilityOfAll (By locator, Duration duration){
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitUntilVisibilityOfAll (WebElement webElement, Duration duration){
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    protected void waitUntilPresenceOfAll (By locator, Duration duration){
        new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

}
