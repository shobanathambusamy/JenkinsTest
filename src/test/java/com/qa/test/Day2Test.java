package com.qa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.ApexBaseTest;

public class Day2Test  extends ApexBaseTest{
	@Test
	void verifyLoginSection_Invalid1() {
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement userId = driver.findElement(By.name("uid"));
		userId.sendKeys("mngr14968*");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("uhytAhu");
		WebElement formName = driver.findElement(By.name("frmLogin"));
		formName.submit();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		Assert.assertNotEquals(alert.getText(), "User or Password is not valid**");
		alert.accept();

	}

	@Test
	void verifyLoginSection_Invalid2() {
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement userId = driver.findElement(By.name("uid"));
		userId.sendKeys("mngr149680");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("");
		WebElement formName = driver.findElement(By.name("frmLogin"));
		formName.submit();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		alert.accept();
	}

	@Test
	void verifyLoginSection_Invalid3() {
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement userId = driver.findElement(By.name("uid"));
		userId.sendKeys("");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("");
		WebElement formName = driver.findElement(By.name("frmLogin"));
		formName.submit();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		alert.accept();
	}

	@Test
	void comparePricesInDifferentPages_Pass1() {
		driver.get(" http://live.guru99.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		WebElement sonyExperiaProduct = driver.findElement(
				By.xpath("//a[contains(text(),'Sony Xperia')]/ancestor::h2/following-sibling::div/child::span"));
		String sonyExperiaCostListPage = sonyExperiaProduct.getText();
		driver.findElement(By.xpath("//img[@alt='Xperia']")).click();
		String sonyExperiaDetailsPage = driver.findElement(By.id("product-price-1")).getText();
		Assert.assertEquals(sonyExperiaCostListPage, sonyExperiaDetailsPage);

	}

	@Test
	void verifyUpdateQuantityErrorMessage_Pass1() {
		driver.get(" http://live.guru99.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		driver.findElement(
				By.xpath("//a[contains(text(),'Sony Xperia')]/ancestor::h2/following-sibling::div[3]/child::button"))
				.click();
		WebElement quantityInput1 = driver.findElement(By.xpath("//table[@id = 'shopping-cart-table']//input"));
		quantityInput1.sendKeys("1000");
		WebElement updateButton = driver
				.findElement(By.xpath("//table[@id = 'shopping-cart-table']//button[@value='update_qty']"));
		updateButton.submit();
		String errorMessage = driver.findElement(By.xpath("//table[@id = 'shopping-cart-table']//p")).getText();
		Assert.assertEquals("* The maximum quantity allowed for purchase is 500.", errorMessage);
		Assert.assertNotEquals("* The maximum quantity allowed for purchase is 50000.", errorMessage);
	}

}
