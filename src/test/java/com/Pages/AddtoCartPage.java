package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {
	
public WebDriver driver;
	
	@FindBy(xpath = "//h2[text() = '$122.00']") //this is your assignment
	private WebElement priceOfLaptop;
	
	@FindBy(xpath = "//div[@class='form-group']/descendant::button")
    private WebElement addtocart;

    @FindBy(id = "cart-total")
    private WebElement itemLink;

    @FindBy(linkText = "View Cart")
    private WebElement viewCartLink;

    @FindBy(css = "#content > form > div > table > tbody > tr > td:nth-child(2) > a")
    private WebElement productInCart;


    

    public void clickOnViewItemLink(){
    	itemLink.click();}
    
    public void clickOnViewCartLink(){
    	viewCartLink.click();}
    
   public void clickOnAddTocart() {
	   addtocart.click();
   }
    
    public boolean productInCartDisplayed(){
        boolean display = productInCart.isDisplayed();
        return display;
    }
	
	
	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean displayStatusOfLaptopPrice() {
		boolean display = priceOfLaptop.isDisplayed();
		return display;
	}
}
