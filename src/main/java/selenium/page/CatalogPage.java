package selenium.page;

import org.openqa.selenium.*;
import selenium.element.Header;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage{

    private final Header header;

    public Header getHeader() {
        return header;
    }

    private final By categoryListBtn = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]"),
                     categoryLinksList = By.xpath("//div[text()='Category']" +
                             "//following-sibling::div[@data-role='content']//a"),
                     productCards = By.xpath("//div[@class='column main']//ol//li"),
                     productCardsNames = By.xpath("//div[@class='column main']//ol//strong//a"),
                     nextPageBtn = By.xpath("//li[contains(@class, 'pages-item-next')]"),
                     sizeOptions = By.xpath("//div[@class=\"swatch-option text\"]"),
                     colorOptions = By.xpath("//div[@class=\"swatch-option color\"]"),
                     addToCartBtn = By.xpath("//button[@title='Add to Cart']"),
                     productAddedMessage = By.xpath("//div[@role=\"alert\"]");

    private static WebElement selectedProduct;

    public CatalogPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
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
        waitUntilPresenceOfAll(productCardsNames, Duration.ofSeconds(1));

        for (WebElement cardLink : driver.findElements(productCardsNames)) {
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

    // TODO: add product selection by name
    public CatalogPage moveToFirstProduct(){
        waitUntilPresenceOfAll(productCards, Duration.ofSeconds(1));

        selectedProduct = driver.findElements(productCards).get(0);

        actions.moveToElement(selectedProduct).pause(Duration.ofSeconds(1)).perform();
        return new CatalogPage(driver);
    }

    // TODO: add size selection by name
    public CatalogPage clickChooseFirstSizeOptionBtn(){
        selectedProduct.findElements(sizeOptions).get(0).click();
        return new CatalogPage(driver);
    }

    // TODO: add color selection by name
    public CatalogPage clickChooseFirstColorOptionBtn(){
        selectedProduct.findElements(colorOptions).get(0).click();
        return new CatalogPage(driver);
    }

    public CatalogPage clickAddToCartBtnOnProduct(){
        actions.moveToElement(selectedProduct).perform();

        selectedProduct.findElement(addToCartBtn).click();

        return new CatalogPage(driver);
    }

    public boolean isProductAddedMessageExist(){
        try{
            waitUntilPresenceOfAll(productAddedMessage, Duration.ofSeconds(3));
        }
        catch (TimeoutException e){
            return false;
        }
        return true;
    }
}
