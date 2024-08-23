package com.Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.Product_Page;
import com.TestBase.Test_Base;

public class Search_ProductTest extends Test_Base{
	public Search_ProductTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public Product_Page searchProductPage;

	@BeforeMethod
    public void startUp(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
    }

    @Test
    public void verifySearchResultsAreDisplayed(){
    searchProductPage = new Product_Page(driver);
    searchProductPage.enterToSearchBoxTextField(dp.getProperty("productName"));
    searchProductPage.clickOnSearchButton();
    Assert.assertTrue(searchProductPage.searchResultsForProductIsDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
	

}
