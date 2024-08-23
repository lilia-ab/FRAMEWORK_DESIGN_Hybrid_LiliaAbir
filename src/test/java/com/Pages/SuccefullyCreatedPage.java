package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccefullyCreatedPage {
public WebDriver driver;
	
	@FindBy(css = "div#content>p:nth-child(2)")
	private WebElement accountSuccessfullyCreatedMessage;
	
	public SuccefullyCreatedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountSuccessCreatedMessage() {
		boolean displayStatus = accountSuccessfullyCreatedMessage.isDisplayed();
		return displayStatus;
	}

}
