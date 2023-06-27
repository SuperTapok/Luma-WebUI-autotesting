package test.catalog;

import org.junit.jupiter.api.*;
import page.Home;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest extends BaseTest {
    @Test
    void categoryFiltrationTest(){
        /*
        Checking product filtration for "Hoodies & Sweatshirts" category
         */
        Home homePage = new Home();

        String categoryName = "Tank";

        catalogPage = homePage.getHeader().clickButtonMenTopsBtn();

        assertTrue(catalogPage.changeCategory(categoryName).isProductsNamesContain(categoryName));
    }
}
