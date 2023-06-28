package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import selenium.page.CatalogPage;
import selenium.page.HomePage;

import static selenium.configuration.Settings.*;

public class BaseTest {
    private WebDriver driver;

    protected HomePage homePage;
    protected CatalogPage catalogPage;

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
