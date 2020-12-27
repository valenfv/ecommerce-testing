package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECProductCartModal extends AbstractUIObject {

    /*
    * This component is present on the search page and on the home page
    * */

    @FindBy(id = "layer_cart_product_title")
    private ExtendedWebElement productName;

    @FindBy(css = "span.cross")
    private ExtendedWebElement closeModalButton;

    private static final String ROOT_ID = "layer_cart";

    public ECProductCartModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ECProductCartModal(WebDriver driver) {
        super(driver);
    }


    public String getProductName(){
        return productName.getText();
    }

    public void closeModal(){
        closeModalButton.click();
    }


}
