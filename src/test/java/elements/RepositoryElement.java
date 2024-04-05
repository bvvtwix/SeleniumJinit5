package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepositoryElement {

    private final WebElement root;

    private final By repoName = By.cssSelector("h3 a");
    private final By repoLabel = By.cssSelector("span.Label");
    private final By repoStar = By.cssSelector("button[aria-label='Star this repository']");
    private final By repoUnStar = By.cssSelector("button[aria-label='Unstar this repository']");

    public RepositoryElement(WebElement repositoriesCard) {
        this.root = repositoriesCard;
    }

    public String getRepoName() {
        return root.findElement(repoName).getText();
    }

    public String getRepoLabel() {
        return root.findElement(repoLabel).getText();
    }

    public void clickToStarBtn() {
        root.findElement(repoStar).click();
    }

    public void clickToUnStarBtn() {
        root.findElement(repoUnStar).click();
    }
}
