package selenium.page;

import org.openqa.selenium.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage{
    private final By categoryListBtn = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]"),
                     categoryLinksList = By.xpath("//div[text()='Category']" +
                             "//following-sibling::div[@data-role='content']//a"),
                     productCards = By.xpath("//div[@class='column main']//ol//strong//a"),
                     nextPageBtn = By.xpath("//li[contains(@class, 'pages-item-next')]");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage changeCategory(String categoryName) {
        driver.findElement(categoryListBtn).click();
        waitUntilVisibilityOfAll(categoryLinksList, Duration.ofSeconds(1));

        for (WebElement categoryLink : driver.findElements(categoryLinksList)) {
            if (categoryLink.getAttribute("text").contains(categoryName)) {
                categoryLink.click();

                return this;
            }
        }

        return this;
    }

    public boolean isProductsNamesContain(String categoryName){
        List<String> productNames = getProductsNamesFromAllPages();

        for (String productName : productNames){
            if (!productName.toLowerCase().contains(categoryName.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    public List<String> getProductsNamesFromAllPages() {
        List<String> productNames = new ArrayList<>();

        do{
            productNames.addAll(getProductsNames());
        } while(clickBtnNextPageBtn());

        return productNames;
    }

    public List<String> getProductsNames() {
        List<String> productNames = new ArrayList<>();
        waitUntilPresenceOfAll(productCards, Duration.ofSeconds(1));

        for (WebElement cardLink : driver.findElements(productCards)) {
            productNames.add(cardLink.getAttribute("text"));
        }

        return productNames;
    }


    public boolean clickBtnNextPageBtn(){
        if (isNextPageBtnExist()){
            driver.findElements(nextPageBtn).get(1).click();

            return true;
        }

        return false;
    }

    public boolean isNextPageBtnExist(){
        try {
            waitUntilPresenceOfAll(nextPageBtn, Duration.ofSeconds(1));

        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


}
