package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage{

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage checkAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.forceToastMessage")));
        return this;
    }
}
