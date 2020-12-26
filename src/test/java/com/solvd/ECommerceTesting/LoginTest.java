package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.solvd.ECommerceTesting.components.ECHeaderComponent;
import com.solvd.ECommerceTesting.pages.login.ECAbstractLoginPage;
import com.solvd.ECommerceTesting.pages.login.ECHomeLogin;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import com.solvd.ECommerceTesting.services.LoginService;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends AbstractTest implements LoginService {

    @Test
    public void loginMailValidation(){
        ECAbstractLoginPage lp = openLoginPage(getDriver());

        lp.typeEmailAndPassword(RandomStringUtils.random(10, true, true), RandomStringUtils.random(10, true, true));
        Assert.assertTrue(lp.isEmailWrong(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input didn't show an error when typing the wrong value");
        lp.typeEmailAndPassword(RandomStringUtils.random(10, true, true) + "@gmail.com", RandomStringUtils.random(10, true, true));
        Assert.assertFalse(lp.isEmailWrong(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input showed an error when typing the right value");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "login", dsUid = "TUID")
    public void loginSuccess(HashMap<String, String> args){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        ECMyAccountPage map = (ECMyAccountPage) lp.login(args.get("mail"), args.get("pass"));
        ECHeaderComponent hc = map.getHeader();
        Assert.assertTrue(hc.isLoggedIn(), "User was not logged in");
    }

}
