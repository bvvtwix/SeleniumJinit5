package pages;

import common.Credentials;
import elements.RepositoryElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RepositoriesPage extends BasePage {

    public static final String REPO_URL = BASE_URL + Credentials.getLoginName() + "?tab=repositories";
    private final By repoFilter = By.id("your-repos-filter");
    private final By repoNamesList = By.cssSelector("#user-repositories-list li a");
    private final By repoList = By.cssSelector("#user-repositories-list li");
    private final By filterResultMessage = By.cssSelector("div.user-repo-search-results-summary");

    public RepositoriesPage(String url) {
        super(url);
    }

    public void putRepoNameToFilter(String repo) {
        driver.findElement(repoFilter).sendKeys(repo);
    }

    public String getFilterResultMessage() {
        waitForVisibilityOfElement(filterResultMessage);
        return driver.findElement(filterResultMessage).getText();
    }

    public void enterRepoNameToFilterRepoList(String repo) {
        putRepoNameToFilter(repo);
        waitForVisibilityOfElement(filterResultMessage);
    }

    public boolean checkFilteredList(String searchedRepoName) {
        List<WebElement> repoCards = driver.findElements(repoList);
        return repoCards.stream()
                .map(RepositoryElement::new)
                .allMatch(repoCard -> repoCard.getRepoName()
                        .contains(searchedRepoName));
    }

}
