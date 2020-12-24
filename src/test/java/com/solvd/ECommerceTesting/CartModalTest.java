package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CartModalTest extends AbstractTest {

    @Test(dataProvider = "DP1")
    public void productNameTest(ECHomePage.Tabs tab){
        ECHomePage hp = new ECHomePage(getDriver());
        hp.open();
        hp.switchTab(tab);
        IntStream.range(0, hp.getItemsCount(tab)).forEach(item -> {
            ECProductCartModal cm = hp.addToCart(item, tab);
            WebDriverWait wait = new WebDriverWait(getDriver(),10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(cm.getRootBy()));
            Assert.assertTrue(cm.getProductName().equals(hp.getProductName(item, tab)));
            cm.closeModal();
        });
    }

    @DataProvider(parallel = false, name = "DP1")
    public static Object[] tabsDataProvider()
    {
        return ECHomePage.Tabs.values();
    }
}
