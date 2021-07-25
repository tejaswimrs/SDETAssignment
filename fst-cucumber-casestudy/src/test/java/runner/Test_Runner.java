package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\SignUp"},
glue= {"Step_Definition"},
dryRun=false,
strict=true,
monochrome=true,
plugin = {"html:testoutput/output.html","junit:testoutput/output.xml","json:testoutput/output.json"})


public class Test_Runner {

}
