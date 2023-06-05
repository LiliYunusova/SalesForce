package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.Account;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewContactPage;

import java.util.concurrent.TimeUnit;

public class ContactTest {

    @Test
    public void createContactTest(){
        User user = new User("https://app-platform-5651.lightning.force.com/","liliya.yunusova.spare-5mle@force.com", "32kq4Wx_");
        Account account = new Account("AccountAQA", "www.tms.com", "Apparel");
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(option);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(user.getUrl());
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(user.getLogin());
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@id = 'Login']")).click();

        Contact contact = new Contact("Bob","Smith");
        NewContactPage newContactPage = new NewContactPage(driver);
        newContactPage.openContactPage()
                .createContact(contact);
        String actualTextContactCreated = driver.findElement(By.xpath("//span[@class = 'custom-truncate uiOutputText']")).getText();
        String expectedTextContactCreated = "Bob Smith";
        Assert.assertEquals(actualTextContactCreated,expectedTextContactCreated);
    }
}
