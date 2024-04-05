package tests;

import extentions.AfterEachExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AfterEachExtension.class)
public class UserHomePageTest extends BaseTest {

    @Disabled
    @Test
    void checkHomePageMainHeaderText() {
        loginPage.open();
        logger.info("Login page opened");
        loginPage.successLogin();
        logger.info("Log in success");
        assertEquals(userHomePage.getHomeHeaderText(), "Home");
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"auto-repo-1"})
    void existingRepoNameGetError(String repoName) {
        loginPage.open();
        logger.info("Login page opened");
        loginPage.successLogin();
        logger.info("Log in success");
        userHomePage.enterRepoData(repoName);
        logger.info("Repo name: " + repoName + " entered");
        assertEquals(userHomePage.getRepoExistError(), "The repository " + repoName + " already exists on this account.");
        logger.info("Error message: '" + userHomePage.getRepoExistError() + "' present");
    }

}
