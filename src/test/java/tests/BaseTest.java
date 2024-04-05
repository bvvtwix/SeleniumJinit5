package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.LoginPage;
import pages.RepoDetailsPage;
import pages.RepositoriesPage;
import pages.UserHomePage;
import static pages.BasePage.BASE_URL;
import static pages.LoginPage.LOGIN_PAGE_URL;
import static pages.RepoDetailsPage.REPO_DETAILS_URL;
import static pages.RepositoriesPage.REPO_URL;

public abstract class BaseTest {
// test commit
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    LoginPage loginPage = new LoginPage(LOGIN_PAGE_URL);
    UserHomePage userHomePage = new UserHomePage(BASE_URL);
    RepoDetailsPage repoDetailsPage = new RepoDetailsPage(REPO_DETAILS_URL);
    RepositoriesPage repositoriesPage = new RepositoriesPage(REPO_URL);

}
