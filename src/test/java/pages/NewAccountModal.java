package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import wrappers.CheckBox;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

import java.awt.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal open() {
        driver.get(BASE_URL+ "lightning/o/Account/new?count=1");
        return this;
    }

    public NewAccountModal createAccount() {
        Account account = Account.builder()
                .name("Account Name")
                .phone("Phone")
                .fax("Fax")
                .website("Website")
                .site("Account Site")
                .ownership("Ownership")
                .city("Billing City")
                .street("Shipping Street")
                .priority("Customer Priority")
                .build();
        return this;
    }

    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Account Site").write(account.getSite());
        new Picklist(driver, "Ownership").select("Public");
        new Input(driver, "Billing City").write(account.getCity());
        new CheckBox(driver, "VIP Client").select();
        new CheckBox(driver, "TeachMeSkills").select();
        new TextArea(driver, "Shipping Street").write(account.getStreet());
        new Picklist(driver, "Customer Priority").select("High");
        return this;
    }

    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='SaveEdit']")));
        return this;
    }

    public NewAccountModal clickSaveButton() {
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
        return this;
    }
}
