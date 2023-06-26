package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static configuration.Settings.driver;

public class CatalogPage {
    WebElement categoryListBtn = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]"));
    List<WebElement> productCards = new ArrayList<>();

    WebElement nextPageBtn;

    public void changeCategory(String categoryName) {
        categoryListBtn.click();
        List<WebElement> categoryLinksList = (new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[text()='Category']//" +
                                "following-sibling::div[@data-role='content']//a"))));
        for (WebElement categoryLink : categoryLinksList) {
            if (categoryLink.getAttribute("text").contains(categoryName)) {
                categoryLink.click();
                break;
            }
        }
    }

    public List<String> getProductsNamesFromAllPages() {
        List<String> productNames = new ArrayList<>();
        do {
            productCards = (new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@class='column main']//ol//strong//a"))));

            for (WebElement cardLink : productCards) {
                productNames.add(cardLink.getAttribute("text"));
            }
        } while (goToNextPage());

        return productNames;
    }

    public boolean goToNextPage(){
        try {
            nextPageBtn = (new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//li[contains(@class, 'pages-item-next')]")))).get(1);
        } catch (TimeoutException e) {
            return false;
        }

        nextPageBtn.click();
        return true;
    }

}
