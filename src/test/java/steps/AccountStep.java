package steps;

import dto.Account;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.LoginPage;
import pages.NewAccountModal;

public class AccountStep {

    WebDriver driver;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountModal = new NewAccountModal(driver);
    }

    public void createAccount(Account account) {
        newAccountModal.open()
                .isPageOpened()
                .createAccount(account)
                .clickSaveButton();
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");        }
        };
    }
}
