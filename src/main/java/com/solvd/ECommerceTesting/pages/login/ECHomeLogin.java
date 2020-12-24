package com.solvd.ECommerceTesting.pages.login;

import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import org.openqa.selenium.WebDriver;

public class ECHomeLogin extends ECAbstractLoginPage{

    public ECHomeLogin(WebDriver driver) {
        super(driver);
    }

    @Override
    public ECAbstractPage login(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
        return new ECMyAccountPage(driver);
    }
}
