package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import selenium.page.CatalogPage;
import selenium.page.HomePage;
import selenium.page.ShoppingCartPage;

import static selenium.configuration.Settings.*;

public class BaseTest {
    protected WebDriver driver;

    protected HomePage homePage;
    protected CatalogPage catalogPage;
    protected ShoppingCartPage shoppingCartPage;

    @BeforeEach
    void setDriver(){
        driver = createDriver();
        driver.get(URL);

        homePage = new HomePage(driver);
    }

    @AfterEach
    void disableDriver(){
        driver.quit();
    }

}
