package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/sri/Documents/workspace/freeCRMCucumberTest/src/test/java/featureFiles", 
		glue = "stepDefs", 
		strict = true, 
		dryRun = false, 
		monochrome = true, 
		plugin = {"pretty", "html:html-output","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		tags = {"@Sri"})
public class TestRunner {
//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(new File("/Users/sri/Documents/workspace/freeCRMCucumberTest/src/test/java/config/extent-config.xml"));
//	}
}
