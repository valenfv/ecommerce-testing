package com.solvd.ECommerceTesting.pages.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.components.ECHeaderComponent;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ECAbstractLoginPage extends ECAbstractPage {
    public static final String DIV_ERROR_CLASS = "form-error";

    @FindBy(id = "header")
    private ECHeaderComponent header;

    @FindBy(id = "email")
    protected ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@id='%s']/..")
    private ExtendedWebElement emailInputDiv;

    @FindBy(id = "passwd")
    protected ExtendedWebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    protected ExtendedWebElement submitButton;

    public ECAbstractLoginPage(WebDriver driver) {
        super(driver);
    }

    /*
    * login method must be abstract due to redirections
    * Uses
    *   - Regular login page - redirects to my account
    *   - Shopping cart login page - redirects to home shopping car address component
    * */
    public abstract ECAbstractPage login(String email, String password);

    public boolean isEmailWrong(EmailInputId inputId){
        return emailInputDiv.format(inputId.getId()).getAttribute("class").contains(DIV_ERROR_CLASS);
    }

    public void typeEmailAndPassword(String email, String password){
        emailInput.type(email);
        passwordInput.type(password);
    }

    public ECHeaderComponent getHeader() {
        return header;
    }

    public enum EmailInputId{
        LOGIN("email"),
        SIGNUP("email_create");

        private String id;

        EmailInputId(String id) {
            this.id = id;
        }

        public String getId(){
            return this.id;
        }
    }
}
