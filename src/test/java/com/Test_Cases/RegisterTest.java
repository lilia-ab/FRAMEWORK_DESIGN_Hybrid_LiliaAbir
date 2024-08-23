package com.Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.RegistrationPage;
import com.Pages.SuccefullyCreatedPage;
import com.TestBase.Test_Base;
import com.Utilities.Utilitie;



public class RegisterTest extends Test_Base {
	public RegisterTest() throws Exception {
		super();
	}

	    
        public WebDriver driver;
        public RegistrationPage registerpage;
		public HomePage homepage;
		public SuccefullyCreatedPage successpage;	
	
	
	@BeforeMethod
	 
	    public void Setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		registerpage = homepage.combiningTwoActionsToNavigateToRegisterPage();	        }
	@Test
	public void verifyRegisterWithAllDetails() {
		successpage = registerpage.AllDetailsToNavigateToAccountSuccessPage(dp.getProperty("FirstName"),
				dp.getProperty("lastname"), Utilitie.emailDateTimeStamp(), dp.getProperty("telephoneText"), prop.getProperty("validpsw"), 
				prop.getProperty("validpsw"));
		Assert.assertTrue(successpage.validateAccountSuccessCreatedMessage());
		
	}
	
	@AfterMethod
	    public void tearDown(){
	        driver.quit();
	    }
}
