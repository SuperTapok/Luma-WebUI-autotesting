package test.catalogShoppingCartIntegration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.BaseTest;

public class CatalogShoppingCartIntegrationTest extends BaseTest {
    /**
     * adding new product to cart and checking product quantity equal to 1
     */
    @Test
    void addUniqueProductToCart(){
        // adding new product
        catalogPage = homePage.getHeader().clickButtonMenTopsBtn()
                                          .moveToFirstProduct()
                                          .clickChooseFirstSizeOptionBtn()
                                          .clickChooseFirstColorOptionBtn()
                                          .clickAddToCartBtnOnProduct();

        // product successfully added
        Assertions.assertTrue(catalogPage.isProductAddedMessageExist());

        shoppingCartPage = catalogPage.getHeader().clickButtonShoppingCartButton().clickButtonViewShoppingCart();

        Assertions.assertEquals(1, shoppingCartPage.getProductsQty());
    }
}
