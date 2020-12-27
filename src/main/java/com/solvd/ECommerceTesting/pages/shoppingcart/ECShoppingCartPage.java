package com.solvd.ECommerceTesting.pages.shoppingcart;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ECShoppingCartPage extends ECAbstractPage {

    @FindBy(css = "div#center_column > p")
    private ExtendedWebElement warningMessage;

    @FindBy(css = "#cart_summary tbody tr")
    private List<ExtendedWebElement> products;

    @FindBy(css = "#cart_summary tbody tr .cart_delete.text-center div a")
    private List<ExtendedWebElement> productRemoveButtons;

    private final String PRODUCT_DELETE_BUTTON = ".cart_delete.text-center div a";

    public ECShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemsCount(){
        return products.size();
    }

    public boolean isShoppingCartEmpty(){
        return warningMessage.isVisible();
    }

    public void removeAllItems(){
        productRemoveButtons.stream().forEach(item -> {
            item.click();
            item.waitUntilElementDisappear(10);
        });
    }
}
