package tests;

import dto.Account;
import dto.AccountFactory;
import org.openqa.selenium.By;

import org.testng.annotations.Test;


public class AccountTest extends BaseTest{

    @Test(invocationCount = 3)
    public void checkCreateAccount() throws InterruptedException {
        Account account = AccountFactory.getAccount("Public", "High");
        loginStep.auth("tborodich@tms.sandbox", "Password003!");
        accountStep.waitForPageLoaded();
        accountStep.createAccount(account);
    }
}
