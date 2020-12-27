package com.solvd.ECommerceTesting.pages.account;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ECOrderHistoryPage extends ECAbstractPage {

    @FindBy(css = "#order-list tbody tr")
    private List<ExtendedWebElement> orders;

    private final String ORDER_REFERENCE = "td.history_link a";
    private final String ORDER_DATE = "td.history_date.bold";
    private final String ORDER_TOTAL = "td.history_price";

    public ECOrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderReference(int orderNumber){
        return orders.get(orderNumber).findExtendedWebElement(By.cssSelector(ORDER_REFERENCE)).getText();
    }

    public String getOrderDate(int orderNumber){
        return orders.get(orderNumber).findExtendedWebElement(By.cssSelector(ORDER_DATE)).getText();
    }

    public String getOrderTotal(int orderNumber){
        return orders.get(orderNumber).findExtendedWebElement(By.cssSelector(ORDER_TOTAL)).getText();
    }
}
