package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Input {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void write(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input", label)))).sendKeys(text);
    }
}
