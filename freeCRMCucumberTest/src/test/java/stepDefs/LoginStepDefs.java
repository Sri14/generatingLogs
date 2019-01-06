package stepDefs;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.TestBase;

public class LoginStepDefs extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	@Given("^user is on FreeCRM site$")
	public void user_is_on_FreeCRM_site() throws Throwable {
		loginpage = new LoginPage();
		TestBase.initialization();
		String title = loginpage.validateloginpage();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		loginpage = new LoginPage();
		// homepage = loginpage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		rs.next();
		String DBusername = rs.getString(1);
		String DBpassword = rs.getString(2);
		homepage = loginpage.login(DBusername, DBpassword);
	}

	@When("^user is logged in to homepage$")
	public void user_is_logged_in_to_homepage() throws Throwable {
		String homepageTitle = homepage.validateHomePage();
		Assert.assertEquals("CRMPRO", homepageTitle);
		driver.quit();
	}

}
