package com.solvd.ECommerceTesting.pages.shoppingcart;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECCartAddressPage extends ECAbstractPage {
    // TODO THIS

    @FindBy(id = "id_address_delivery")
    private ExtendedWebElement addressDropDown;

    @FindBy(id = "%s")
    private ExtendedWebElement addressBox;

    private final String ADDR_TITLE = ".address_title";
    private final String ADDR_COMPANY = ".address_company";
    private final String ADDR_ADDR1_ADDR2 = ".address_address1.address_address2";
    private final String ADDR_UPDATE = ".address_update a";

    public ECCartAddressPage(WebDriver driver) {
        super(driver);
    }

    public String getAddrTitle(AddressType at){
        return addressBox.format(at.getId()).findExtendedWebElement(By.cssSelector(ADDR_TITLE)).getText();
    }

    public String getAddrCompany(AddressType at){
        return addressBox.format(at.getId()).findExtendedWebElement(By.cssSelector(ADDR_COMPANY)).getText();
    }

    public String getAddrAddr(AddressType at){
        return addressBox.format(at.getId()).findExtendedWebElement(By.cssSelector(ADDR_ADDR1_ADDR2)).getText();
    }

    public ECAbstractPage updateAddr(AddressType at){
        addressBox.format(at.getId()).findExtendedWebElement(By.cssSelector(ADDR_UPDATE)).click();
        // TODO address add page
        return null;
    }

    public enum AddressType{
        DELIVERY("address_delivery"),
        INVOICE("address_invoice");

        private String id;

        AddressType(String id){
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

}
