package tests;

import extentions.AfterEachExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({AfterEachExtension.class})
public class LoginPageTest extends BaseTest {

    @Test
    void checkMainHeaderText() {
        loginPage.open();
        logger.info("Login page opened");
        assertEquals(loginPage.getSignInMainHeaderText(), "Sign in to GitHub!!!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"baduser"})
     void checkSuccessLogin(String value) {
        loginPage.open();
        loginPage.successLoginByCredentials(value);
    }


    @Test
    void checkThatMainElementPresent() {
        loginPage.open();
        assertTrue(!loginPage.mainElementPresent());
    }


    @Test
    void incorrectLoginOrPasswordErrorMessageAppear() {
        loginPage.open();
        loginPage.unsuccessLogin();
        assertEquals(loginPage.getIncorrectLoginErrorMessageText(), "Incorrect username or password.");
    }
}
