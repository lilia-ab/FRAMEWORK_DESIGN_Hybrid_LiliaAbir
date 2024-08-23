package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Product_Page {

public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	
	@FindBy(css = "div.button-group>button:nth-child(1)")
	private WebElement addToCartButton;
	
	
	
	@FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "#search > span > button")
    private WebElement searchButton;
	
    @FindBy(xpath = "//*[@id= 'content']/div[3]/div/div/div[2]/div[1]/h4/a")
    private WebElement productSearchIsDisplayed;

   

	public Product_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validProductPresence() {
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
	}
	
	public AddtoCartPage clickOnAddToCartButton() {
		addToCartButton.click();
		return new AddtoCartPage(driver);
	}
	
	
	
	public void enterToSearchBoxTextField(String product){
		searchBox.sendKeys(product);
		}
	public void clickOnSearchButton(){
		searchButton.click();
}
	
public boolean searchResultsForProductIsDisplayed(){
        boolean display = productSearchIsDisplayed.isDisplayed();
        return display;

    }
}
