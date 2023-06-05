package pages;

import elements.DropDownContact;
import elements.InputFieldContact;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewContactPage extends BasePage{

    public static final String SAVE_CONTACT_BUTTON = "//button[@name = 'SaveEdit']";

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    public NewContactPage openContactPage(){
        driver.get("https://app-platform-5651.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    public void createContact(Contact contact){
        new InputFieldContact(driver,"First Name").inputContactText(contact.getFirstName());
        new InputFieldContact(driver,"Last Name").inputContactText(contact.getLastName());
        new DropDownContact(driver,"Account Name").selectAccount();
        driver.findElement(By.xpath(SAVE_CONTACT_BUTTON)).click();
    }
}
