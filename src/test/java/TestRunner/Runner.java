package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features\\login.feature"
		,glue={"StepDefinition"}
		,monochrome = true
		,dryRun = false
	    ,plugin = {"html:target/cucumber-html-report.html", "json:target/cucumber-json-report.json" }
		,tags = "@Test3"
		)


public class Runner {

}
