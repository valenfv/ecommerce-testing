package com.solvd.ECommerceTesting.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.components.ECHeaderComponent;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ECHomePage extends ECAbstractPage{

    @FindBy(id = "header")
    private ECHeaderComponent header;

    /*
    *   BUG:
    *   Locator formatter won't work with css selector
    * */
    @FindBy(xpath = "//ul[@id='home-page-tabs']/li/a[@class='%s']")
    private ExtendedWebElement hpGenericTab;

    @FindBy(css = "#homefeatured li")
    private List<ExtendedWebElement> popularItems;

    @FindBy(css = "#layer_cart")
    private ECProductCartModal cartModal;

    @FindBy(xpath = "//div[@id='center_column']/div/ul[@id='%s']")
    private ExtendedWebElement items;

    private static final String CSS_ADD_TO_CART_BUTTON = "div div.right-block div.button-container a[title='Add to cart']";
    private static final String CSS_ITEM_NAME = ".product-name";

    public ECHomePage(WebDriver driver) {
        super(driver);
    }

    public ECHeaderComponent getHeader(){
        return header;
    }

    public void switchTab(Tabs tab){
        hpGenericTab.format(tab.getId()).click();
    }

    private List<ExtendedWebElement> getHomePageItems(Tabs tab){
        return items.format(tab.getId()).findExtendedWebElements(By.cssSelector("li"));
    }

    private ExtendedWebElement getItem(int itemNumber, Tabs tab){
        return getHomePageItems(tab).get(itemNumber);
    }

    public ECProductCartModal addToCart(int itemNumber, Tabs tab){
        ExtendedWebElement elem = getItem(itemNumber, tab);
        elem.hover();
        elem.findExtendedWebElement(By.cssSelector(CSS_ADD_TO_CART_BUTTON)).click();
        return new ECProductCartModal(driver);
    }

    public int getItemsCount(Tabs tab){
        return getHomePageItems(tab).size();
    }

    public String getProductName(int itemNumber, Tabs tab){
        return getItem(itemNumber, tab).findExtendedWebElement(By.cssSelector(CSS_ITEM_NAME)).getText();
    }

    public ECProductCartModal getCartModal(){
        return cartModal;
    }

    public enum Tabs{
        POPULAR("homefeatured"),
        BESTSELLER("blockbestsellers");

        private String id;

        Tabs(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

}
