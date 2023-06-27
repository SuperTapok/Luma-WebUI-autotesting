package test;

import org.junit.jupiter.api.*;
import page.Catalog;

import static configuration.Settings.driver;

public class BaseTest {
    protected Catalog catalogPage;

    @BeforeEach
    void setSiteUrlToDriver(){
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterAll
    static void disableDriver(){
        driver.quit();
    }

}
