package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static configuration.Settings.driver;
import static configuration.Settings.waiter;

public class Catalog {
    private final WebElement categoryListBtn = driver.findElement(
            By.xpath("//*[@id=\"narrow-by-list\"]/div[1]"));

    private List<WebElement> categoryLinksList;

    private List<WebElement> productCards;

    private WebElement nextPageBtn;

    public Catalog changeCategory(String categoryName) {
        categoryListBtn.click();
        categoryLinksList = waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[text()='Category']//following-sibling::div[@data-role='content']//a")));

        for (WebElement categoryLink : categoryLinksList) {
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
        productCards = waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@class='column main']//ol//strong//a")));

        for (WebElement cardLink : productCards) {
            productNames.add(cardLink.getAttribute("text"));
        }

        return productNames;
    }


    public boolean clickBtnNextPageBtn(){
        if (isNextPageBtnExist()){
            nextPageBtn.click();

            return true;
        }

        return false;
    }

    public boolean isNextPageBtnExist(){
        try {
            nextPageBtn = waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//li[contains(@class, 'pages-item-next')]"))).get(1);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


}
