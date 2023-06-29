package selenium.element;

import org.openqa.selenium.*;
import selenium.page.BasePage;
import selenium.page.CatalogPage;
import selenium.page.ShoppingCartPage;

import java.time.Duration;

public class Header extends BasePage {
    private final By menBtn = By.xpath("//*[@id='ui-id-5']"),
                     menTopsBtn = By.xpath("//*[@id='ui-id-17']"),
                     shoppingCartButton = By.xpath("//div[@data-block=\"minicart\"]//a"),
                     modalCartEmpty = By.xpath("//*[@id='ui-id-1']"),
                     cartPageLink = By.xpath("//a[contains(@class, 'viewcart')]");

    public Header(WebDriver driver) {
        super(driver);
    }

    // methods

    public CatalogPage clickButtonMenTopsBtn() {
        waitUntilPresenceOfAll(menBtn, Duration.ofSeconds(1));

        actions.moveToElement(driver.findElement(menBtn)).pause(Duration.ofSeconds(1))
                .click(driver.findElement(menTopsBtn)).perform();
        return new CatalogPage(driver);
    }

    public Header clickButtonShoppingCartButton (){
        driver.findElement(shoppingCartButton).click();
        return new Header(driver);
    }

    public ShoppingCartPage clickButtonViewShoppingCart(){
        waitUntilPresenceOfAll(cartPageLink, Duration.ofSeconds(3));

        driver.findElement(cartPageLink).click();
        return new ShoppingCartPage(driver);
    }

    public boolean isShoppingCartEmptyMessageVisible(){
        return driver.findElement(modalCartEmpty).isDisplayed();
    }
}
