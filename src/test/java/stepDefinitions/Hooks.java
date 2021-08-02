package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseDriver;
import utilities.ExcelUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(Scenario scenario) {
        System.out.println("Scenario is started");
        System.out.println("Scenario ID = " + scenario.getId());
        System.out.println("Scenario name = " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {

        System.out.println("Scenario is finished");
        System.out.println("Scenario result is = " + scenario.getStatus());
        System.out.println("Is scenario failed? = " + scenario.isFailed());

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");

        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshotFile,
                        new File("target/failedScreenshots/" + scenario.getId() + dateTime.format(formatter) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ExcelUtility.writeToExcel("src/test/java/resources/apachePOI/ScenarioStatus.xlsx",
                scenario, BaseDriver.threadBrowserName.get(), dateTime.format(formatter));

        BaseDriver.DriverQuit();
    }

}
