package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import com.solvd.ECommerceTesting.components.ECProductResult;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CartModalTest extends AbstractTest {


    @Test(dataProvider = "TabsDataProvider")
    @MethodOwner(owner = "fvazquez")
    @TestPriority(Priority.P3)
    public void checkNameOnModalAndResult(String TUID, ECHomePage.Tabs tab){
        ECHomePage hp = new ECHomePage(getDriver());
        hp.open();
        hp.switchTab(tab);
        for (int item = 0; item < hp.getItemsCount(tab); item++){
            ECProductResult itemResult = null;
            switch (tab){
                case POPULAR:
                    itemResult = hp.getPopularItem(item);
                    break;
                case BESTSELLER:
                    itemResult = hp.getBSItem(item);
                    break;
            }
            ECProductCartModal cm = itemResult.addToCart();
            cm.waitUntil(ExpectedConditions.visibilityOfElementLocated(cm.getRootBy()), 10);
            Assert.assertEquals(cm.getProductName(), itemResult.getName(), "Names must match on modal and result box");
            cm.closeModal();
        }
    }

    @DataProvider(parallel = false, name = "TabsDataProvider")
    public static Object[][] tabsDataProvider()
    {
        return new Object[][]{
                { "TUID: Tab " + ECHomePage.Tabs.POPULAR, ECHomePage.Tabs.POPULAR },
                { "TUID: Tab " + ECHomePage.Tabs.BESTSELLER, ECHomePage.Tabs.BESTSELLER }
        };
    }
}
