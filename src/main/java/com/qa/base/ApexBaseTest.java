package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;




public class ApexBaseTest {
	
	protected WebDriver driver = null;
	@BeforeMethod
	  protected void beforeTest() {
		  
//System.out.println("Before Test");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
	  }

	@AfterMethod
	  protected void cleanUp() {
		//System.out.println("after Test");

	 driver.quit();
	  }

}
