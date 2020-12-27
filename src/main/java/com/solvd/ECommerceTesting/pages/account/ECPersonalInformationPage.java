package com.solvd.ECommerceTesting.pages.account;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ECommerceTesting.pages.ECAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ECPersonalInformationPage extends ECAbstractPage {

    @FindBy(id = "id_gender1")
    private ExtendedWebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private ExtendedWebElement mrsRadioButton;

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "days")
    private ExtendedWebElement daysSelect;

    @FindBy(id = "months")
    private ExtendedWebElement monthSelect;

    @FindBy(id = "years")
    private ExtendedWebElement yearSelect;

    @FindBy(id = "old_passwd")
    private ExtendedWebElement oldPassInput;

    @FindBy(id = "passwd")
    private ExtendedWebElement newPass;

    @FindBy(id = "confirmation")
    private ExtendedWebElement validateNewPass;

    @FindBy(id = "newsletter")
    private ExtendedWebElement newLetterCheckBox;

    @FindBy(id = "optin")
    private ExtendedWebElement specialOffersCheckBox;

    @FindBy(css = "button[name='submitIdentity']")
    private ExtendedWebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private ExtendedWebElement successMessage;

    public ECPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickMrGender(){
        mrRadioButton.click();
    }

    public void clickMrsGender(){
        mrsRadioButton.click();
    }

    public void writeFirstAndLastName(String fname, String lname){
        firstNameInput.type(fname);
        lastNameInput.type(lname);
    }

    public void typeEmail(String email){
        emailInput.type(email);
    }

    public void typeCurrentPass(String pass){
        oldPassInput.type(pass);
    }

    public void typeNewPass(String pass, String validation){
        newPass.type(pass);
        validateNewPass.type(validation);
    }

    public void submitForm(){
        submitButton.click();
        this.waitUntil(ExpectedConditions.visibilityOf(successMessage.getElement()), 10);
    }
}
