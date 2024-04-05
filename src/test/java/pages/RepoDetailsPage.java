package pages;

import common.CommonActions;
import org.openqa.selenium.By;

public class RepoDetailsPage extends BasePage {

    public static final String REPO_DETAILS_URL = BASE_URL + CommonActions.readConfig("reponame", "user");
    public RepoDetailsPage(String url) {
        super(url);
    }

    private final By repoNameHeader = By.cssSelector("a.color-fg-default");
    private final By navTabs = By.cssSelector("nav[aria-label='Repository'] li:not([hidden]");

    public boolean repoNameHeaderPresent() {
        return driver.findElement(repoNameHeader).isDisplayed();
    }

}
