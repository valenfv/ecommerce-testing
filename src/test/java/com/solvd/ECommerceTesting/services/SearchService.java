package com.solvd.ECommerceTesting.services;

import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.search.ECSearchPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public interface SearchService {

    default ECSearchPage search(WebDriver driver, String query){
        ECHomePage hp = new ECHomePage(driver);
        hp.open();
        return hp.getHeader().search(query);
    }
}
