package catalog;

import org.junit.jupiter.api.*;
import page.CatalogPage;
import page.MainPage;

import java.util.List;

import static configuration.Settings.driver;

public class CatalogTest {
    @BeforeEach
    void setSiteUrlToDriver(){
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    void categoryFiltrationTest(){
        /*
        Checking product filtration for "Hoodies & Sweatshirts" category
         */
        MainPage mainPage = new MainPage();

        CatalogPage catalogPage = mainPage.clickButtonMenTopsBtn();

        catalogPage.changeCategory("Hoodies & Sweatshirts");

        List<String> productNames = catalogPage.getProductsNamesFromAllPages();

        for (String productName : productNames){
            //
            Assertions.assertTrue( productName.toLowerCase().contains("hoodie")
                    || productName.toLowerCase().contains("sweatshirt"));
        }
    }

    @AfterAll
    static void disableDriver(){
        driver.quit();
    }
}
