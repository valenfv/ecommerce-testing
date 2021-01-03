package com.solvd.ECommerceTesting.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.components.ECProductCartModal;
import com.solvd.ECommerceTesting.components.ECProductResult;
import com.solvd.ECommerceTesting.pages.products.ECProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ECHomePage extends ECAbstractPage{
    /*
    *   BUG:
    *   Locator formatter won't work with css selector
    * */
    @FindBy(xpath = "//ul[@id='home-page-tabs']/li/a[@class='%s']")
    private ExtendedWebElement hpGenericTab;

    @FindBy(css = "#layer_cart")
    private ECProductCartModal cartModal;

    @FindBy(xpath = "//div[@id='center_column']/div/ul[@id='%s']")
    private ExtendedWebElement items;

    @FindBy(xpath = "//div[@id='center_column']/div/ul[@id='homefeatured']/li")
    private List<ECProductResult> popularITems;

    @FindBy(xpath = "//div[@id='center_column']/div/ul[@id='blockbestsellers']/li")
    private List<ECProductResult> bsItems;


    public ECHomePage(WebDriver driver) {
        super(driver);
    }

    public void switchTab(Tabs tab){
        hpGenericTab.format(tab.getId()).click();
    }

    private List<ExtendedWebElement> getHomePageItems(Tabs tab){
        return items.format(tab.getId()).findExtendedWebElements(By.cssSelector("li"));
    }

    public List<ECProductResult> getPopularITems() {
        return popularITems;
    }

    public List<ECProductResult> getBSItems() {
        return bsItems;
    }

    public ECProductResult getPopularItem(int itemNumber){
        return getPopularITems().get(itemNumber);
    }

    public ECProductResult getBSItem(int itemNumber){
        return getBSItems().get(itemNumber);
    }

    public int getItemsCount(Tabs tab){
        return getHomePageItems(tab).size();
    }

    public ECProductPage popularQuickView(int itemNumber){
        return getPopularItem(itemNumber).quickView(this.getRootElement());
    }

    public ECProductCartModal getCartModal(){
        this.waitUntil(ExpectedConditions.visibilityOf(cartModal.getRootElement()), 10);
        return cartModal;
    }

    // enum for tabs on homepage
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
