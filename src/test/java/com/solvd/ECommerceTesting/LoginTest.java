package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.ECommerceTesting.pages.login.ECAbstractLoginPage;
import com.solvd.ECommerceTesting.pages.login.ECHomeLogin;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import com.solvd.ECommerceTesting.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest implements LoginService {

    @Test
    public void loginWrongEmail(){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        lp.typeEmailAndPassword("pepardo", "cacona");
        Assert.assertTrue(lp.isEmailWrong(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input didn't show an error when typing the wrong value");
    }

    @Test
    public void loginRightEmail(){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        lp.typeEmailAndPassword("pepardo@gmail.com", "cacona");
        Assert.assertTrue(!lp.isEmailWrong(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input showed an error when typing the right value");
    }

    @Test
    public void loginRightValues(){
        ECHomeLogin lp = openLoginPage(getDriver());
        ECMyAccountPage map = (ECMyAccountPage) lp.login("val@val.com", "lalala");
    }
}
