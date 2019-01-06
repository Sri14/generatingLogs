package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import utils.TestBase;

public class DealsStepDef extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	@Given("^user is logged in and on homepage$")
	public void user_is_logged_in_and_on_homepage() throws Throwable {
		TestBase.initialization();
		loginpage = new LoginPage();
		// homepage = loginpage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		rs.next();
		String DBusername = rs.getString(1);
		String DBpassword = rs.getString(2);
		System.out.println("**********command is here*************");
		homepage = loginpage.login(DBusername, DBpassword);
		System.out.println("**********command is here now*************");
		homepage.validateHomePage();
	}

	@Then("^user clicks on new deal$")
	public void user_clicks_on_new_deal() throws Throwable {
		homepage = new HomePage();
		homepage.newDeal();
		Thread.sleep(3000);
		driver.quit();
	}

	@Then("^user enters firstname and lastname and company and position$")
	public void user_enters_firstname_and_lastname_and_company_and_position() throws Throwable {

	}

	@Then("^user saves the deal$")
	public void user_saves_the_deal() throws Throwable {

	}

}
