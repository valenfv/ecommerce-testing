package com.solvd.ECommerceTesting.pages.products;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECProductPage extends ECAbstractPage {

    @FindBy(css = "h1[itemprop='name']")
    private ExtendedWebElement name;

    public ECProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return name.getText();
    }
}
