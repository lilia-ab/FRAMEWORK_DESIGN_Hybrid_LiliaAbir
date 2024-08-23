package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pages.Product_Page;


public class HomePage {

	

public WebDriver driver;
	
	@FindBy(linkText="My Account")
	private WebElement MyAccount;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
		
	@FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Desktops")
    private WebElement homePageElement;

    @FindBy(linkText = "Laptops & Notebooks")
    private WebElement linkOnHomePage;
    @FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	
    public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
public void myaccount() {
	MyAccount.click();
}
public void login() {
	login.click();
}
public RegistrationPage combiningTwoActionsToNavigateToRegisterPage() {
	MyAccount.click();	
	registerLink.click();
	return new RegistrationPage(driver);
	}

public void clickOnRegisterLink(){
	registerLink.click();
	}
public void clickOnLinkOnHomepage(){
	linkOnHomePage.click();
	}
public Product_Page navigateToProductPage(String validProductText) {
	searchBox.sendKeys(validProductText);
	searchButton.click();
	return new Product_Page(driver);
}
public boolean elementPresentOnHomePage(){
    boolean display = homePageElement.isDisplayed();
    return display;

}


}
