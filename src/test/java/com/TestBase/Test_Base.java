package com.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utilities.Utilitie;

public class Test_Base {
	public Properties prop;
	public Properties dp;
	public FileInputStream ip;
	public FileInputStream ip1;
	public ChromeOptions options;
	public WebDriver driver; 
	
	
	public Test_Base() throws Exception {
	prop = new Properties();
	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Config\\Config.properties");
	prop.load(ip);
	
    dp = new Properties();
	ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\DataTest\\TestData.properties");
	dp.load(ip1);
	}


public WebDriver initializeBrowserAndOpenApplication(String browser) {
	if(browser.equals("chrome")) {
		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
		driver = new ChromeDriver(options);
	}else if(browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}else if(browser.equals("edge")) {
		driver = new EdgeDriver();
	}
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilitie.ImplicitWait));
	driver.get(prop.getProperty("url"));
	return driver;
}
}
