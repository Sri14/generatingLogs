package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static ResultSet rs;
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/sri/Documents/workspace/freeCRMCucumberTest/src/test/java/config/FreeCRMData.properties");
		prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root","Database@123");
		
		Statement stm = con.createStatement();
		
		String logindetails = "select * from freeCRMLogin";
		rs = stm.executeQuery(logindetails);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public String getReportConfigPath(){
		 String reportConfigPath = prop.getProperty("/Users/sri/Documents/workspace/freeCRMCucumberTest/src/test/java/config/extent-config.xml");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		}
	

	
	
}
