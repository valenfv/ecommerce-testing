package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.ECommerceTesting.components.ECHeader;
import com.solvd.ECommerceTesting.pages.login.ECAbstractLoginPage;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import com.solvd.ECommerceTesting.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends AbstractTest implements LoginService {

    /*
    * ALL sensitive data is being encrypted (passwords)
    * Key for decryption is under ./src/main/resources/crypto.key
    * */

    @Test
    @MethodOwner(owner = "fvazquez")
    public void loggingInWithInvalidFormatEmail(){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        // validates wrong email
        lp.typeEmailAndPassword(getRandomInvalidEmail(), getRandomPassword());
        Assert.assertTrue(lp.isEmailWrong(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input didn't show an error when typing the invalid email");
        //validates right email
        lp.typeEmailAndPassword(getRandomValidEmail(), getRandomPassword());
        Assert.assertTrue(lp.isEmailValid(ECAbstractLoginPage.EmailInputId.LOGIN), "Email input showed an error when typing the valid email");
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "fvazquez")
    @XlsDataSourceParameters(path = "xls/ECData.xlsx", sheet = "login", dsUid = "TUID")
    public void loggingInWithValidCredentials(HashMap<String, String> args){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        ECMyAccountPage map = (ECMyAccountPage) lp.login(args.get("mail"), args.get("pass"));
        ECHeader hc = map.getHeader();
        Assert.assertTrue(hc.isLoggedIn(), "User seems not to be logged in");
    }


    @Test
    @MethodOwner(owner = "fvazquez")
    public void loggingInWithInvalidCredentials(){
        ECAbstractLoginPage lp = openLoginPage(getDriver());
        lp = lp.loginWrongCredentials(getRandomValidEmail(), getRandomPassword());
        Assert.assertTrue(lp.credentialsWrong(), "Error wasn't shown when entering wrong credentials");
    }
}
