package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource",
				glue= {"stepdefinition", "hooks"},
	 			plugin={"pretty", "html:target/cucu/cucureports.html"}
				)
public class Testrunner {

}
