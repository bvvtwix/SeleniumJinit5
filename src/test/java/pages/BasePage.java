package pages;

import common.CommonActions;
import helpers.WebDriverContainer;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Timeouts.EXPLICIT_WAIT;

public abstract class BasePage {

    WebDriver driver = WebDriverContainer.getDriver();
    final Logger logger = LogManager.getLogger(this.toString());
    public static final String BASE_URL = CommonActions.readConfig("base.url", "general");
    protected String url;

    public BasePage(String url) {
        this.url = url;
    }

    @Step
    public void open() {
        driver.get(this.url);
    }

    public WebElement waitForVisibilityOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
