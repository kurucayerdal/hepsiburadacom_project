package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseDriver {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver(){

        if (threadBrowserName.get()==null){
            threadBrowserName.set("chrome");
        }
        if (threadDriver.get()==null){

            switch (threadBrowserName.get()){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    threadDriver.set(new OperaDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver();
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }
        return threadDriver.get();
    }

    public static void DriverQuit(){

        if (threadDriver.get()!=null)
        {
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }

    }



}
