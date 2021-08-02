package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(

        features = {"src/test/java/featureFiles/_02_Login.feature"},
        glue = {"stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportLogin.html"}
)
public class _02_LoginRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass(){
        Reporter.loadXMLConfig("src/test/java/xmlFiles/ExtentReport.xml");
        Reporter.setSystemInfo("User Name","Erdal Kurucay");
        Reporter.setSystemInfo("Website Name","hepsiburada.com");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Department", "QA");
        Reporter.setSystemInfo("Explanation", "Login Test Scenario");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
    }

}
