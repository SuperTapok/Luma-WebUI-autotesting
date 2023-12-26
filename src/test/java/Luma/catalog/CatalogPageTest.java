package Luma.catalog;

import org.junit.jupiter.api.*;
import Luma.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogPageTest extends BaseTest {
    /**
     * checking product filtration for "Tanks" category
     */
    @Test
    void categoryFiltrationTest(){
        String categoryName = "Tank";

        catalogPage = homePage.getHeader().clickButtonMenTopsBtn();

        assertTrue(catalogPage.changeCategory(categoryName).isProductsNamesContain(categoryName));
    }
}
