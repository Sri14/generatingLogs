package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestBase;

public class LoginPage extends TestBase{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//input[@type='text']")
	WebElement username;
	
	@FindBy (xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement loginBtn;
	

	
	public HomePage login(String usn, String pass) throws Exception{
		username.sendKeys(usn);
		password.sendKeys(pass);
		Thread.sleep(3000);
		loginBtn.click();
		return new HomePage();
	}
	
	
	public String validateloginpage(){
		return driver.getTitle();
	}
}
	


