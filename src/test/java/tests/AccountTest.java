package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.Account;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.NewAccountPage;

import java.util.concurrent.TimeUnit;

public class AccountTest {

    @Test
    public void createAccountTest(){
        User user = new User("https://app-platform-5651.lightning.force.com/","liliya.yunusova.spare-5mle@force.com", "32kq4Wx_");
        Account account = new Account("AccountAQA", "www.tms.com", "Apparel");
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(option);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(user.getUrl());
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(user.getLogin());
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@id = 'Login']")).click();

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.openPage()
                      .create(account);
    }
}
