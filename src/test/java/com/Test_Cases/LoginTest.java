package com.Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.TestBase.Test_Base;

public class LoginTest extends Test_Base{
	public LoginTest() throws Exception {
		super();
	}

	    public WebDriver driver;
	    public HomePage homepage;
	    public LoginPage loginPage;
	   	
	    
@BeforeMethod
public void Setup() {
     driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
     homepage = new HomePage(driver);
     homepage.myaccount();
     homepage.login();	
}

@Test
public void validLoginWithValidCredentials() throws Exception {
	loginPage = new LoginPage(driver);
	loginPage.enteremail(prop.getProperty("validemail"));
    loginPage.enterpassword(prop.getProperty("validpsw"));
    loginPage.clickonlogin();



	
}
@AfterMethod
public void tearDown() {
 driver.quit();
}


}
