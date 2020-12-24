package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.services.LoginService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends AbstractTest implements LoginService {

    @Test
    public void addToCartTest(){
        ECHomePage hp = new ECHomePage(getDriver());
        hp.open();
        ECProductCartModal pcm = hp.addToCart(0, ECHomePage.Tabs.POPULAR);
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pcm.getRootBy()));
        Assert.assertTrue(pcm.getProductName().equals(hp.getProductName(0, ECHomePage.Tabs.POPULAR)), "Names on homepage and modal didn't match");
        pcm.closeModal();
    }

    @Test(dataProvider = "DP1")
    public void addItemToCartTest(String name, String price){

    }


    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] itemsDataProvider()
    {
        return new Object[][] {
                { "Faded Short Sleeve T-shirts", "$16.51" },
                { "Blouse", "$27.00" },
                { "Printed Dress", "$26.00" },
                { "Printed Summer Dress", "$30.50" }
        };
    }
}