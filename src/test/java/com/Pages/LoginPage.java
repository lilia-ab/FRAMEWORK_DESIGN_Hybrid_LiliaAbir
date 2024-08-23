package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	
@FindBy(id="input-email")
private WebElement emailbox;

@FindBy(id="input-password")
private WebElement passwordbox;

@FindBy(css="input.btn.btn-primary")
private WebElement loginbutton;

@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
private WebElement invalidEmailPasswordWarning; 

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void enteremail(String email) {
	emailbox.sendKeys(email);
}
public void enterpassword(String password) {
	passwordbox.sendKeys(password);
}
public void clickonlogin() {
	loginbutton.click();
}
}
