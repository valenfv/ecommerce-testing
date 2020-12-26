package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import org.testng.annotations.Test;

public class ProductTest extends AbstractTest {

    @Test
    public void productQuickViewTest(){
        ECHomePage hp = new ECHomePage(getDriver());
        hp.open();

        //ECProductContent pc = hp.popularQuickView(0);
    }
}
