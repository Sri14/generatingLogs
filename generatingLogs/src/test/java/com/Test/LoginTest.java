package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUP(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		log.info("*********launching chrome browser*********");
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
		
	}
	
	@Test(priority=1)
	public void valiadateTitle(){
		String title = driver.getTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service",title);
	}
	
	@Test(priority=2)
	public void validatelogo(){
		Boolean logo =  driver.findElement(By.xpath("//img[@alt='free crm logo']")).isDisplayed();
		Assert.assertTrue(logo);	
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
