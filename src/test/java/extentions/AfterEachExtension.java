package extentions;

import helpers.WebDriverContainer;
import io.qameta.allure.Allure;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Path.of;

public class AfterEachExtension implements AfterEachCallback {

//    private WebDriver driver = WebDriverContainer.getDriver();
    private final Logger logger = LogManager.getLogger(this.toString());

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Проверяем, было ли выброшено исключение в тесте
        try {
            if (context.getExecutionException().isPresent()) {
                // Если да, значит тест упал, и мы делаем скриншот
                logger.error("Test is failed");
                logger.info("after if " + context.getRequiredTestMethod().toString());
                takeScreenshot(context.getDisplayName());
                logger.error("after screenshot");
            }
        }
        finally {
            WebDriverContainer.closeDriver();
        }
    }

    // Метод для создания скриншота
    private void takeScreenshot(String testName) {
        logger.info("takeScreenshot method called");
        try {
            // Получаем скриншот как байтовый массив
            logger.info("takeScreenshot indide try");
            byte[] screenshot = ((TakesScreenshot) WebDriverContainer.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Создаем директорию для сохранения скриншотов, если она не существует
            Path directory = of("screenshots");
            if (!Files.exists(directory)) {
                logger.info("takeScreenshot inside if");
                Files.createDirectory(directory);
            }
            // Путь к файлу скриншота
            Path screenshotPath = directory.resolve(testName + ".png");
            // Сохраняем скриншот в файл
            Files.write(screenshotPath, screenshot);
            logger.info("takeScreenshot after write");
            // Добавляем скриншот в Allure
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", screenshot);
            logger.error("Screenshot saved: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
