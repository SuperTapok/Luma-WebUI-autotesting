package Luma.shoppingCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Luma.BaseTest;

public class ShoppingCartTest extends BaseTest {
    /**
     * checking that shopping cart is empty by default when user isn't authorised
     */
    @Test
    void unauthorisedUserShoppingCartEmptyMessage(){
        Assertions.assertTrue(homePage.getHeader().clickButtonShoppingCartButton()
                .isShoppingCartEmptyMessageVisible());
        Assertions.assertEquals("Home Page", driver.getTitle());
    }
}
