package com.Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.AddtoCartPage;
import com.Pages.HomePage;
import com.Pages.Product_Page;
import com.TestBase.Test_Base;

public class Add_To_Cart_Test extends Test_Base{
	public Add_To_Cart_Test() throws Exception {
        super();
    }
 
 
	public WebDriver driver;
	public HomePage homepage;
	public Product_Page productpage;
	public AddtoCartPage addtocartpage;

    

    @BeforeMethod
	public void completeCheckOutSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		productpage = homepage.navigateToProductPage(dp.getProperty("productName"));
	}
	
	@Test(priority=1)
	public void addToCartValidProduct() {
		Assert.assertTrue(productpage.validProductPresence());	
	}
	
	
	@Test(priority=2)
	public void validateCompleteCheckoutWithValidProductPositiveFlow(){
		addtocartpage = productpage.clickOnAddToCartButton();
		Assert.assertTrue(addtocartpage.displayStatusOfLaptopPrice());
		/*driver.findElement(By.id("button-cart")).click();*/
		String actualSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedSuccessMessage = "Success: You have added ";
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
		
	
	}



	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
