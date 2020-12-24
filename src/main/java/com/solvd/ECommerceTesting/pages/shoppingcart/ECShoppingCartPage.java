package com.solvd.ECommerceTesting.pages.shoppingcart;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECShoppingCartPage extends ECAbstractPage {

    @FindBy(css = "div#center_column > p")
    private ExtendedWebElement warningMessage;

    public ECShoppingCartPage(WebDriver driver) {
        super(driver);
    }
}
