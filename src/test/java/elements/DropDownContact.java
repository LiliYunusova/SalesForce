package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class DropDownContact {

    private static final String DROPDOWN_CONTACT_XPATH = "//span[@class ='test-id__field-value slds-size_1-of-1']//*[contains(text(), '%s')]/ancestor::span[contains(@class, 'test')]";
    private static final String SELECT_ACCOUNT_NAME_XPATH = "//*[@field-label = \"Account Name\"]//input";
    private static final String CHOSE_ACCOUNT = "//*[@field-label = \"Account Name\"]//input/parent::div/following-sibling::div//li[2]";

    private WebDriver driver;
    private String label;

    public DropDownContact(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectAccount(){
         new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(DROPDOWN_CONTACT_XPATH,label)))));
         driver.findElement(By.xpath((SELECT_ACCOUNT_NAME_XPATH))).click();
         driver.findElement(By.xpath(CHOSE_ACCOUNT)).click();
    }
}
