package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsPage;

public class AccountTest extends BaseTest{

    @Test
    public void checkCreateAccount() throws InterruptedException {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password003!");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(2000);
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        newAccountModal.createAccount("QA31", "+53627272", "28289", "test.com",
                "Test.com", "Minsk", "31.12.2024",  "Billing Street", ":)");
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
        newAccountsPage.checkAccountCreated();
    }
}
