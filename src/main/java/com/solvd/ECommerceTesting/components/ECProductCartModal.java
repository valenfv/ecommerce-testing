package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ECProductCartModal extends AbstractUIObject {

    @FindBy(id = "layer_cart_product_title")
    private ExtendedWebElement productName;

    @FindBy(css = "span.cross")
    private ExtendedWebElement closeModalButton;


    private static final String ROOT_ID = "layer_cart";

    public ECProductCartModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setRootBy(By.id(ROOT_ID));
    }

    public ECProductCartModal(WebDriver driver) {
        super(driver);
        setRootBy(By.id(ROOT_ID));
    }


    public String getProductName(){
        return productName.getText();
    }

    public void closeModal(){
        closeModalButton.click();
    }

}
