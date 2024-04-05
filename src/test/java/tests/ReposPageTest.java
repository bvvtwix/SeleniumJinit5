package tests;

import extentions.AfterEachExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(AfterEachExtension.class)
public class ReposPageTest extends BaseTest {

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"repo"})
    void filterRepoListByRepoElement(String repo) {
        loginPage.open();
        loginPage.successLogin();
        repositoriesPage.open();
        repositoriesPage.enterRepoNameToFilterRepoList(repo);
        Assertions.assertTrue(repositoriesPage.checkFilteredList(repo));
    }
}
