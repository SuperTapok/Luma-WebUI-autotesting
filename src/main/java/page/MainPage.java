package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

import static configuration.Settings.driver;

public class MainPage {

    private final Actions actions = new Actions(driver);
    private final WebElement menBtn = new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-5']")));
    private final WebElement menTopsBtn = new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-17']")));

    public CatalogPage clickButtonMenTopsBtn() {
        actions.moveToElement(menBtn).pause(Duration.ofSeconds(1)).click(menTopsBtn).perform();
        return new CatalogPage();
    }

}
