package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public class LoginPage extends  BasePage{

    private final By LOGIN = By.xpath("");
    private final By USERNAME_INPUT = By.xpath("//*[@id='username']");
    private final By PASSWORD = By.xpath("//*[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//*[@id='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page is not opened");
        } return this;
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public MainPage login(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new MainPage(driver);
    }
}
