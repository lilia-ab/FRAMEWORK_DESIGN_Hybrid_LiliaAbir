package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "Shopping Cart")
	/*div[@class='col-sm-3']/descendant::span")*/
	private WebElement items;
	

	@FindBy(css = "a.btn.btn-primary")
	private WebElement checkout;
	
	@FindBy(xpath = "//div[@class='pull-right']/descendant::input")
	private WebElement billingDetails;
	
	@FindBy(xpath = "//div[@id='shipping-new']/following-sibling::div/descendant::input")
	private WebElement delivryDetails;
	
	@FindBy(xpath = "//div[@class='buttons']/descendant::input")
	private WebElement delivryMethod;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "//a[@class='agree']/following-sibling::input[2]")
	private WebElement termsAndConditionsContinue;
	
	@FindBy(xpath = "//div[@class='table-responsive']/following-sibling::div/descendant::input")
	private WebElement ConfirmeOrder;
	
	
	public void items() {
		items.click();
	}
	public void checkout() {
		checkout.click();
	}
	public void billingDetails() {
		billingDetails.click();
	}
	public void deliveryDetails() {
		delivryDetails.click();
	}
	public void deliveryMethods() {
		delivryMethod.click();}
		
	public void termesAndConditionsAceptance() {
		termsAndConditions.click();
		
	}
	public void continueButton() {
		termsAndConditionsContinue.click();
	}
	public void confirmOrder() {
		ConfirmeOrder.click();
	}
	
	
}
