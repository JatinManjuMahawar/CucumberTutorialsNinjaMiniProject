package MyRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html: CucumberReport.html",
        "json: CucumberReport.json",
        "junit: CucumberReport.xml"},
        features = "src/test/resources/TestFeatures/",
        glue = {"TestClasses", "MyHooks"},
        tags = "@all")
public class RunnerClassTest extends AbstractTestNGCucumberTests
{
   // Run cmd as admin to publish report on cloud
    //setx /M CUCUMBER_PUBLISH_ENABLED "true"
    //setx /M CUCUMBER_PUBLISH_TOKEN "token code"

}
