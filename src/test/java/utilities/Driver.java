package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    private static final String browserType = Config.getProperty("browser");

    public static WebDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");;
        if (driver == null) {
            switch (browserType) {
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
                default -> driver = new ChromeDriver(chromeOptions);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            return driver;
        }
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
