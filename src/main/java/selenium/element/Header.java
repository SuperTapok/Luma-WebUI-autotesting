package selenium.element;

import org.openqa.selenium.*;
import selenium.page.BasePage;
import selenium.page.CatalogPage;
import java.time.Duration;

public class Header extends BasePage {
    private final By menBtn = By.xpath("//*[@id='ui-id-5']"),
                     menTopsBtn = By.xpath("//*[@id='ui-id-17']");

    public Header(WebDriver driver) {
        super(driver);
    }

    // methods

    public CatalogPage clickButtonMenTopsBtn() {
        actions.moveToElement(driver.findElement(menBtn)).pause(Duration.ofSeconds(1))
                .click(driver.findElement(menTopsBtn)).perform();
        return new CatalogPage(driver);
    }
}
