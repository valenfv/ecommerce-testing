package com.solvd.ECommerceTesting.services;

import com.solvd.ECommerceTesting.pages.login.ECHomeLogin;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public interface LoginService {

    default ECHomeLogin openLoginPage(WebDriver driver){
        ECHomePage hp = new ECHomePage(driver);
        hp.open();
        return hp.getHeader().openSignIn();
    }

    default ECHomePage loginAndReturnToHome(WebDriver driver, String user, String password){
        ECHomePage hp = new ECHomePage(driver);
        hp.open();
        ECHomeLogin hlogin =  hp.getHeader().openSignIn();
        ECMyAccountPage map = (ECMyAccountPage) hlogin.login(user, password);
        return map.getHeader().gotoHomePage();
    }

    default ECMyAccountPage loginDefault(WebDriver driver, String user, String password){
        ECHomePage hp = new ECHomePage(driver);
        hp.open();
        ECHomeLogin hlogin =  hp.getHeader().openSignIn();
        return (ECMyAccountPage) hlogin.login(user, password);
    }

    default String getRandomValidEmail(){
        return RandomStringUtils.random(10, true, true) + "@gmail.com";
    }

    default String getRandomInvalidEmail(){
        return RandomStringUtils.random(10, true, true);
    }

    default String getRandomPassword(){
        return RandomStringUtils.random(10, true, true);
    }

}
