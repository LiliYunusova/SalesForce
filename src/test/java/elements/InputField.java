package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputField {
    private static final String INPUT_XPATH = "//*[text() = '%s']/ancestor::div[contains(@part,'input')]//input";
    private WebDriver driver;
    private String label;

    public InputField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeText(String text){
        String locator = String.format(INPUT_XPATH,label);
        WebElement element = driver.findElement(By.xpath(locator));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}

