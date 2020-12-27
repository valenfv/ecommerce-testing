package com.solvd.ECommerceTesting.pages.products;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ECProductPage extends ECAbstractPage {

    @FindBy(css = "h1[itemprop='name']")
    private ExtendedWebElement name;

    @FindBy(id = "quantity_wanted")
    private ExtendedWebElement quantityInput;

    @FindBy(xpath = "//p[@id='quantity_wanted_p']/a[1]")
    private ExtendedWebElement minusQuantity;

    @FindBy(xpath = "//p[@id='quantity_wanted_p']/a[2]")
    private ExtendedWebElement plusQuantity;

    @FindBy(id = "group_1")
    private ExtendedWebElement sizeDropDown;

    public ECProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return name.getText();
    }

    public String getQuantity(){
        return quantityInput.getText();
    }

    public void pressPlusButton(){
        plusQuantity.click();
    }

    public void pressMinusButton(){
        minusQuantity.click();
    }

}
