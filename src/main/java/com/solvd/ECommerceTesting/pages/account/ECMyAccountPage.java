package com.solvd.ECommerceTesting.pages.account;

import com.solvd.ECommerceTesting.components.ECHeaderComponent;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECMyAccountPage extends ECAbstractPage {

    @FindBy(id = "header")
    private ECHeaderComponent header;

    public ECMyAccountPage(WebDriver driver) {
        super(driver);
    }

    public ECHeaderComponent getHeader() {
        return header;
    }
}
