package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
    private static final String DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::span[contains(@class,'test')]//button";
    private static final String SELECT_OPTION_XPATH = "//*[@role='listbox']//span[contains(text(), 'Apparel')]";
    private WebDriver driver;
    private String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String text){
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(DROPDOWN_XPATH,label)))));
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH,text))).click();

    }
}
