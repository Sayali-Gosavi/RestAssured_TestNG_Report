package StepDefinitions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\features",
				glue= {"StepDefinitions"},
				plugin= {"pretty","testng:target/testNG-reports/testng.html"},
				monochrome = true)
public class TestNGReportRunner extends TestNGReport{

}
