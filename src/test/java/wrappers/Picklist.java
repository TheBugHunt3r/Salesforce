package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Picklist {
    WebDriver driver;
    WebDriverWait wait;
    String label;

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void select(String option) {
        WebElement labelElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//button", label))
        ));

        scrollToElement(labelElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", labelElement);

        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//lightning-base-combobox-item//span[text()='%s']", label, option))
        ));

        scrollToElement(optionElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element
        );
    }
}
