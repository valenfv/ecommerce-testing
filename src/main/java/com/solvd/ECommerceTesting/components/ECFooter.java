package com.solvd.ECommerceTesting.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ECFooter extends AbstractUIObject {

    @FindBy(xpath = "//section[@id = 'social_block']/ul/li[@class = '%s']/a")
    private ExtendedWebElement socialNetworkLink;

    public ECFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getSocialNetworkName(SocialNetworks socialNetwork){
        return socialNetworkLink.format(socialNetwork.getClassName()).getText();
    }

    public enum SocialNetworks{
        FACEBOOK("Facebook", "facebook"),
        TWITTER("Twitter", "twitter"),
        YOUTUBE("Youtube","youtube"),
        GOOGLEP("Google Plus","google-plus");

        private String className;
        private String name;

        SocialNetworks(String name, String className){
            this.className = className;
        }

        public String getClassName() {
            return className;
        }

        public String getName() {
            return name;
        }
    }
}
