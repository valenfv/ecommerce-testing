package com.solvd.ECommerceTesting.pages.account;

import com.solvd.ECommerceTesting.components.ECHeader;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECMyAccountPage extends ECAbstractPage {

    @FindBy(id = "header")
    private ECHeader header;

    public ECMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public ECHeader getHeader() {
        return header;
    }
}
