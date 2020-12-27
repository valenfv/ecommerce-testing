package com.solvd.ECommerceTesting.pages.login;

import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import com.solvd.ECommerceTesting.pages.shoppingcart.ECCartAddressPage;
import org.openqa.selenium.WebDriver;

public class ECCartLoginPage extends ECAbstractLoginPage{

    public ECCartLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ECAbstractPage login(String email, String password){
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
        return new ECCartAddressPage(driver);
    }

    @Override
    public ECAbstractLoginPage loginWrongCredentials(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
        return new ECCartLoginPage(driver);
    }
}
