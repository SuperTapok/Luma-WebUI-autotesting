package element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Catalog;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

import java.time.Duration;

public class Header {
    private final WebElement menBtn = new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-5']")));

    private final WebElement menTopsBtn = new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-17']")));

    // methods
    public Catalog clickButtonMenTopsBtn() {
        actions.moveToElement(menBtn).pause(Duration.ofSeconds(1)).click(menTopsBtn).perform();
        return new Catalog();
    }
}
