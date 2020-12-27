package com.solvd.ECommerceTesting.pages.account;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ECAddressesPage extends ECAbstractPage {
    @FindBy(css = "div.bloc_adresses.row div ul")
    private List<ExtendedWebElement> addresses;

    private final String ADDRESS_TITLE = "li h3";
    private final String ADDRESS_PHONE_MOBILE = "li span[class='address_phone_mobile']";

    public ECAddressesPage(WebDriver driver) {
        super(driver);
    }

    public String getAddressPhoneMobile(int addressNumber){
        return addresses.get(addressNumber).findExtendedWebElement(By.cssSelector(ADDRESS_PHONE_MOBILE)).getText();
    }
    public String getAddressTitle(int addressNumber){
        return addresses.get(addressNumber).findExtendedWebElement(By.cssSelector(ADDRESS_TITLE)).getText();
    }
}
