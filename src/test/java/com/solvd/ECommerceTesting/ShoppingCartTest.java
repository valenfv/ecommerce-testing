package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import com.solvd.ECommerceTesting.components.ECProductResult;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.shoppingcart.ECShoppingCartPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "fvazquez")
    @TestPriority(Priority.P2)
    public void removeItemsUntilCarEmpty(){
        ECHomePage hp = new ECHomePage(getDriver());
        hp.open();
        List<ECProductResult> results = hp.getPopularITems();
        results.stream().forEach(item -> {
            item.addToCart();
            hp.waitUntil(ExpectedConditions.visibilityOf(hp.getCartModal().getRootElement()), 10);
            hp.getCartModal().closeModal();
        });
        ECShoppingCartPage scp = hp.getHeader().goToShoppingCart();
        Assert.assertFalse(scp.isShoppingCartEmpty(), "Shopping cart shouldnt be empty");
        scp.removeAllItems();
        Assert.assertTrue(scp.isShoppingCartEmpty(), "Shopping cart should be empty");
    }


}
