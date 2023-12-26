package Luma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    private final By itemInfo = By.xpath("//tr[@class=\"item-info\"]");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getProductsQty(){
        return driver.findElements(itemInfo).size();
    }
}
