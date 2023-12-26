package Luma;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import Luma.page.CatalogPage;
import Luma.page.HomePage;
import Luma.page.ShoppingCartPage;

import static configuration.Settings.*;

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
