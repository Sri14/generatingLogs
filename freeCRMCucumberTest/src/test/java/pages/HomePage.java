package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestBase;

public class HomePage extends TestBase {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	WebElement newDeal;
	
	@FindBy(xpath = "//input[@type ='image']")
	WebElement search;
	
	public String validateHomePage() {
		return driver.getTitle();
	}
	
	public void newDeal() throws Exception {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(deals).build().perform();
		Thread.sleep(2000);
		newDeal.click();
	}
	
	
}
