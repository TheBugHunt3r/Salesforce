package pages;

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

    public void open() {
        driver.get(BASE_URL+ "lightning/o/Account/new?count=1");
    }

    public void createAccount(String name, String phone, String fax, String website, String site, String city, String date,
                              String Street, String street) {
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Input(driver, "Account Site").write(site);
        new Input(driver, "Billing City").write(city);
        new Input(driver, "SLA Expiration Date").write(date);
        new CheckBox(driver, "VIP Client").select();
        new CheckBox(driver, "VIP Client").select();
        new CheckBox(driver, "TeachMeSkills").select();
        new Picklist(driver, "Ownership").select("Public");
        new Picklist(driver, "Customer Priority").select("High");
        new Picklist(driver, "SLA").select("Silver");
        new TextArea(driver, "Billing Street").write(Street);
        new TextArea(driver, "Shipping Street").write(street);
    }
}
