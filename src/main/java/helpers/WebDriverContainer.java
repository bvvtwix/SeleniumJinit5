package helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;

import java.io.File;
import java.time.Duration;

import static constants.Timeouts.IMPLICIT_WAIT;

public class WebDriverContainer {

    // NOTE: если драйвер статик, то не работает параллельный запуск
    private static WebDriver driver;

    public static WebDriver getDriver() {
        final Logger logger = LogManager.getLogger(WebDriverContainer.class);


        if (driver == null) {
            logger.info("Driver created");
            System.out.println(driver);
            Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setPlatform(Platform.MAC);

            switch (browser) {
                case chrome:
//                    caps.setBrowserName(Browser.CHROME.browserName());
                    driver = new ChromeDriver();
                    break;
                case firefox:
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}
