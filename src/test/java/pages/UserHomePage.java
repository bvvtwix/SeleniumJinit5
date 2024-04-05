package pages;

import helpers.WebDriverContainer;
import org.openqa.selenium.By;

public class UserHomePage extends BasePage {
    public UserHomePage(String url) {
        super(url);
    }
    private static int repoNameCounter = 1;
    private static String lastRepoName = null;
    private static By homeHeader = By.cssSelector("h2[data-target='feed-container.feedTitle']");
    private static By createRepoSideBtn = By.cssSelector("div.dashboard-sidebar a.mr-2[href*='new']");
    private static By repoNameInput = By.id("repository[name]");
    private static By createNewRepoBtn = By.cssSelector("button[value='Create a new repository']");
    private static By repoExistError = By.cssSelector("span[data-target='primer-text-field.validationMessageElement']");

    public String getHomeHeaderText() {
        return waitForVisibilityOfElement(homeHeader).getText();
    }

    public void clickToCreateRepoBtc() {
        driver.findElement(createNewRepoBtn).click();
    }

    public String getRepoExistError() {
        return waitForVisibilityOfElement(repoExistError).getText();
    }


    private void fillRepoName(String repoName) {
        driver.findElement(repoNameInput).sendKeys(repoName);

    }

    private String getRepoName() {
        String newRepoName = "auto-repo-" + repoNameCounter;
        lastRepoName = newRepoName;
        repoNameCounter++;
        return newRepoName;
    }

    private void clickToCreateRepoBtn() {
        driver.findElement(createNewRepoBtn).click();
    }

    public void enterRepoData(String repoName) {
        fillRepoName(repoName);
    }
}
