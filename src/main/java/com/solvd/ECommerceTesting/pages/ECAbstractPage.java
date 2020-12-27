package com.solvd.ECommerceTesting.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.ECommerceTesting.components.ECFooter;
import com.solvd.ECommerceTesting.components.ECHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECAbstractPage extends AbstractPage {

    @FindBy(id = "header")
    private ECHeader header;

    @FindBy(id = "footer")
    private ECFooter footer;

    public ECAbstractPage(WebDriver driver) {
        super(driver);
    }

    public ECHeader getHeader(){
        return header;
    }
    public ECFooter getFooter() {
        return footer;
    }
}
