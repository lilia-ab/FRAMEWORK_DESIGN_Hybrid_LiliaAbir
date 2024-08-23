package com.Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.AddtoCartPage;
import com.Pages.CheckoutPage;
import com.Pages.HomePage;
import com.Pages.Product_Page;
import com.TestBase.Test_Base;
public class Checkout_Test extends Test_Base{

public Checkout_Test() throws Exception {
    super();
}



public WebDriver driver;
public HomePage homepage;
public Product_Page searchProductPage;
public AddtoCartPage addtocartpage;
public CheckoutPage checkoutpage;


	
       
@BeforeMethod
public void completeCheckOutSetup() {
driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
homepage = new HomePage(driver);
searchProductPage = homepage.navigateToProductPage(dp.getProperty("productName"));
addtocartpage = searchProductPage.clickOnAddToCartButton();
driver.findElement(By.id("button-cart")).click();

		}
    
    @Test
 public void checkOut(){
   
    	
    checkoutpage = new CheckoutPage();
    checkoutpage.items();
    checkoutpage.checkout();
    checkoutpage.billingDetails();
    checkoutpage.deliveryDetails();
    checkoutpage.deliveryMethods();
    checkoutpage.termesAndConditionsAceptance();
    checkoutpage.continueButton();
    checkoutpage.confirmOrder();


    }
@AfterMethod
    public void tearDown(){
        driver.quit();
}
}
