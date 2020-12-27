package com.solvd.ECommerceTesting.pages.search;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.ECommerceTesting.components.ECProductResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ECSearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@id = 'center_column']/ul[contains(@class, 'product_list grid row')]/li")
    private List<ECProductResult> results;

    public ECSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ECProductResult> getResults(){
        return results;
    }

}
