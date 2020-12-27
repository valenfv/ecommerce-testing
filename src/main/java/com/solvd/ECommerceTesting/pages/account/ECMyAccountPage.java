package com.solvd.ECommerceTesting.pages.account;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.components.ECHeader;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECMyAccountPage extends ECAbstractPage {

    @FindBy(id = "header")
    private ECHeader header;

    @FindBy(xpath = "//i[@class='icon-list-ol']/..")
    private ExtendedWebElement orderHistoryLink;

    @FindBy(xpath = "//i[@class='icon-ban-circle']/..")
    private ExtendedWebElement creditSlipsLink;

    @FindBy(xpath = "//i[@class='icon-building']/..")
    private ExtendedWebElement addressesLink;

    @FindBy(xpath = "//i[@class='icon-user']/..")
    private ExtendedWebElement personalInformationLink;

    @FindBy(xpath = "//i[@class='icon-heart']/..")
    private ExtendedWebElement wishListLink;


    public ECMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public ECPersonalInformationPage goToPersonalInformation(){
        personalInformationLink.click();
        return new ECPersonalInformationPage(driver);
    }

    public ECAddressesPage goToAddressesPage(){
        addressesLink.click();
        return new ECAddressesPage(driver);
    }

    public ECOrderHistoryPage goToOrderHistoryPage(){
        orderHistoryLink.click();
        return new ECOrderHistoryPage(driver);
    }

    public ECWishListPage goToWishListPage(){
        wishListLink.click();
        return new ECWishListPage(driver);
    }

    public ECHeader getHeader() {
        return header;
    }

    public enum MyAccountLinks{
        ORDER_HISTORY("icon-list-ol"),
        CREDIT_SLIPS("icon-ban-circle"),
        ADDRESSES("icon-building"),
        PERSONAL_INFORMATION("icon-user"),
        WISHLIST("icon-heart");

        private String iconClass;
        MyAccountLinks(String iconClass){
            this.iconClass = iconClass;
        }

        public String getIconClass() {
            return iconClass;
        }
    }
}
