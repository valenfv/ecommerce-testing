package com.solvd.ECommerceTesting.pages.account;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ECWishListPage extends ECAbstractPage {

    @FindBy(id = "name")
    private ExtendedWebElement newWishListInput;

    @FindBy(id = "submitWishlist")
    private ExtendedWebElement submitWishList;

    @FindBy(xpath = "//div[@id= 'block-history']/table/tbody/tr")
    private List<ExtendedWebElement> wishLists;

    private final String WL_NAME = "td[1]/a";
    private final String WL_QTY = "td[2]";
    private final String WL_VIEWED = "td[3]";
    private final String WL_CREATED = "td[4]";
    private final String WL_DIRECTLINK = "td[5]/a";
    private final String WL_DELETE_BUTTON = "td[6]/a";

    public ECWishListPage(WebDriver driver) {
        super(driver);
    }

    public void createWishList(String name){
        newWishListInput.type(name);
        submitWishList.click();
        int wlNumber = wishLists.size();
        this.waitUntil(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#block-history table tbody tr"), wlNumber + 1), 10);
    }

    public String getWLName(int wl){
        return wishLists.get(wl).findExtendedWebElement(By.xpath(WL_NAME)).getText();
    }

    public String getWLQty(int wl){
        return wishLists.get(wl).findExtendedWebElement(By.xpath(WL_QTY)).getText();
    }

    public String getWLViewed(int wl){
        return wishLists.get(wl).findExtendedWebElement(By.xpath(WL_VIEWED)).getText();
    }

    public String getWLCreated(int wl){
        return wishLists.get(wl).findExtendedWebElement(By.xpath(WL_CREATED)).getText();
    }

    public void clickWLDirectLink(int wl){
        wishLists.get(wl).findExtendedWebElement(By.xpath(WL_DIRECTLINK)).click();
    }

    public void deleteWLByNumber(int wl){
        wishLists.get(wl).findExtendedWebElement(By.xpath(WL_DELETE_BUTTON)).click();
    }

    public boolean deleteWLByName(String name){
        ExtendedWebElement ewe = wishLists.stream().filter(s -> s.findExtendedWebElement(By.xpath(WL_NAME)).getText().equals(name)).findFirst().orElse(null);
        if(ewe != null){
            ewe.findExtendedWebElement(By.xpath(WL_DELETE_BUTTON)).click();
            acceptAlert();
            //driver.switchTo().alert().accept();
            return true;
        }
        return false;
    }

    public boolean isWishListPresent(String name){
        return wishLists.stream().anyMatch(s -> s.findExtendedWebElement(By.xpath(WL_NAME)).getText().equals(name));
    }
}
