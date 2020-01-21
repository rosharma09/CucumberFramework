package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		// We need to tell junit where the feature file and step defination class is available
		features = "C:\\Users\\rosharma\\eclipse-workspace\\CucumberFramework\\src\\main\\java\\feature", 
		glue = "stepDefination")

public class TestRunner {
}
