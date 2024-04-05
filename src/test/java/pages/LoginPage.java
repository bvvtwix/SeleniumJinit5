package pages;

import common.Credentials;
import common.CredentialsNew;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

@Getter
public class LoginPage extends BasePage {

    private final By loginInput = By.id("login_field");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.cssSelector("input[value='Sign in']");
    private final By signInMainHeader = By.cssSelector("div[id='login'] h1");
    private final By incorrectLoginOrPasswordErrorMessage = By.cssSelector("#js-flash-container div[role='alert']");
    public static final String LOGIN_PAGE_URL = BASE_URL + "login";

    public LoginPage(String url) {
        super(url);
    }

    @Step
    public void successLogin() {
        logger.info("successLogin email " + Credentials.getEmail());
        logger.info("successLogin password " + Credentials.getPassword());
        fillUserName(Credentials.getEmail());
        fillPassword(Credentials.getPassword());
        clickToSignInBtn();
    }

    @Step
    public void successLoginByCredentials(String credentialType) {
        logger.info("successLoginByCredentials method start with value - " + credentialType);
        CredentialsNew credentials = new CredentialsNew();
        credentials.getCredentials(credentialType);
        fillUserName(credentials.getUserEmail());
        fillPassword(credentials.getUserPassword());
    }

    @Step
    public void unsuccessLogin() {
        fillUserName(Credentials.getEmail());
        fillPassword(Credentials.getPassword() + "some text");
        clickToSignInBtn();
    }

    public String getIncorrectLoginErrorMessageText() {
        return driver.findElement(incorrectLoginOrPasswordErrorMessage).getText();
    }

    private void clickToSignInBtn() {
        driver.findElement(signInButton).click();
    }

    private void fillUserName(String userName) {
        driver.findElement(loginInput)
                .sendKeys(userName);
    }

    private void fillPassword(String password) {
        driver.findElement(passwordInput)
                .sendKeys(password);
    }

    public String getSignInMainHeaderText() {
        logger.info("Проверяем заголовок " + driver.findElement(signInMainHeader).getText());
        return driver.findElement(signInMainHeader).getText();
    }

    public boolean mainElementPresent() {
        try {
            logger.info("Checking main elements present");
            waitForVisibilityOfElement(getLoginInput());
            waitForVisibilityOfElement(getPasswordInput());
            waitForVisibilityOfElement(getSignInButton());
            return true;
        }
        catch (NoSuchElementException e) {
            logger.error("One of elements absent");
            return false;
        }

    }

}
