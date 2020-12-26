package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.ECommerceTesting.pages.products.ECProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ECProductResult extends AbstractUIObject {

    private static final String CSS_ADD_TO_CART_BUTTON = "div div.right-block div.button-container a[title='Add to cart']";
    private static final String CSS_ITEM_NAME = ".product-name";

    @FindBy(css = CSS_ADD_TO_CART_BUTTON)
    private ExtendedWebElement addToCartButton;

    @FindBy(css = CSS_ITEM_NAME)
    private ExtendedWebElement productName;

    @FindBy(className = "quick-view")
    private ExtendedWebElement quickViewButton;

    public ECProductResult(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ECProductCartModal addToCart(){
        addToCartButton.click();
        return new ECProductCartModal(driver);
    }

    public String getName(){
        return productName.getText();
    }

    public ECProductPage quickView(WebElement pageRoot){
        quickViewButton.click();
        return new ECProductPage(driver);
    }
}
