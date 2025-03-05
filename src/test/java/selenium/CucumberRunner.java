package selenium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:selenium" ,plugin = {"pretty"}, monochrome = true)
public class CucumberRunner {

}
