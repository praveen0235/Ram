 package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)

@io.cucumber.junit.CucumberOptions(
		features = "FeatureFiles",
		 glue= {"stepDefinitions","baseinit"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:test-output/RerunCases/rerun.txt","json:test-output/cucumber-JSON-report/JSONReport.json","junit:test-output/cucumber-XML-report/XMLReport.xml"},
		 monochrome = true,
		 dryRun = false		 
		 ,tags = {"not @No","@Yestess"}
 )

public class Runner {
	
	
	}
