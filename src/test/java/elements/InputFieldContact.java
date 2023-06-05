package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFieldContact {

    private static final String CONTACT_XPATH = "//*[contains(text(), '%s')]/following-sibling::div[1]//input";

    private WebDriver driver;
    private String label;

    public InputFieldContact(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputContactText(String text){
        String locator = String.format(CONTACT_XPATH,label);
        WebElement element = driver.findElement(By.xpath(locator));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}
