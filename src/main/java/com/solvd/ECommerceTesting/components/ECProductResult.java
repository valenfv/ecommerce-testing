package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.ECommerceTesting.pages.products.ECProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ECProductResult extends AbstractUIObject {

    /*
     * This component is present on the search page and on the home page
     * */

    @FindBy(css = "div div.right-block div.button-container a[title='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = ".product-name")
    private ExtendedWebElement productName;

    @FindBy(className = "quick-view")
    private ExtendedWebElement quickViewButton;

    public ECProductResult(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public String getName(){
        return productName.getText();
    }

    public ECProductPage quickView(WebElement pageRoot){
        quickViewButton.click();
        return new ECProductPage(driver);
    }
}
