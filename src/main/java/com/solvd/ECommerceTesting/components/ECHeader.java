package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.ECommerceTesting.pages.login.ECHomeLogin;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.search.ECSearchPage;
import com.solvd.ECommerceTesting.pages.shoppingcart.ECShoppingCartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECHeader extends AbstractUIObject {

    @FindBy(css = "div.header_user_info a.login")
    private ExtendedWebElement singInButton;

    @FindBy(css = "div.header_user_info a.logout")
    private ExtendedWebElement logOutButton;

    @FindBy(css = ".shopping_cart > a")
    private ExtendedWebElement shoppingCartLink;

    @FindBy(css = "#header_logo a")
    private ExtendedWebElement logoLinkToHome;

    @FindBy(id = "search_query_top")
    private ExtendedWebElement searchInput;

    @FindBy(css = "#searchbox button")
    private ExtendedWebElement searchButton;


    public ECHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ECHomeLogin openSignIn(){
        singInButton.click();
        return new ECHomeLogin(driver);
    }

    public ECShoppingCartPage goToShoppingCart(){
        shoppingCartLink.click();
        return new ECShoppingCartPage(driver);
    }

    public ECHomePage gotoHomePage(){
        logoLinkToHome.click();
        return new ECHomePage(driver);
    }

    public ECSearchPage search(String item){
        searchInput.type(item);
        searchButton.click();
        return new ECSearchPage(driver);
    }

    public ECHomeLogin logOut(){
        logOutButton.click();
        return new ECHomeLogin(driver);
    }

    public boolean isLoggedIn(){
        return logOutButton.isPresent();
    }
}
