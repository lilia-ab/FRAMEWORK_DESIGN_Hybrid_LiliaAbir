package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	public WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement FirstNamedBox;

    @FindBy(name = "lastname")
    private WebElement LastNameBox;

    @FindBy(name = "email")
    private WebElement emailBox;

    @FindBy(name = "telephone")
    private WebElement telephoneBox;

    @FindBy(name = "password")
    private WebElement passwordBox;

    @FindBy(name = "confirm")
    private WebElement confirmPasswordBox;

    @FindBy (name = "agree")
    private WebElement privacyPolicyConfirm;

    @FindBy (css  = "input.btn.btn-primary")
    private WebElement clickOnContinue;
    
    @FindBy(xpath = "//input[@name = 'newsletter' and @value='1']")
	private WebElement newsLetterButton;
	
    
    public RegistrationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);}
    
    public void enterFirstName(String FirstName) {
    	FirstNamedBox.sendKeys(FirstName);
    	
		}
    public void entrerLastName(String LastName) {
    	LastNameBox.sendKeys(LastName);
    }
    public void enterEmail(String email) {
    	emailBox.sendKeys(email);
    }
    public void enterTelephone(String telephone) {
    	telephoneBox.sendKeys(telephone);
    }
    public void enterPassWord(String password) {
    	passwordBox.sendKeys(password);
    }
    public void confirmPassWord(String confirmpassword) {
    	confirmPasswordBox.sendKeys(confirmpassword);
    }
    public void newsLetter() {
    	newsLetterButton.click();
    	
    }
    public void privacyPoliveConfirm() {
    	privacyPolicyConfirm.click();
    }
    public void clickContinueButton() {
    	clickOnContinue.click();	
	}
    
	public SuccefullyCreatedPage AllDetailsToNavigateToAccountSuccessPage(String FirstName, 
			String LastName, String email, String telephone, String password, String confirmpassword) {
		FirstNamedBox.sendKeys(FirstName);
		LastNameBox.sendKeys(LastName);
		emailBox.sendKeys(email);
		telephoneBox.sendKeys(telephone);
		passwordBox.sendKeys(password);
		confirmPasswordBox.sendKeys(confirmpassword);
		newsLetterButton.click();
		privacyPolicyConfirm.click();
		clickOnContinue.click();
		return new SuccefullyCreatedPage(driver);
	}
	
	

}
