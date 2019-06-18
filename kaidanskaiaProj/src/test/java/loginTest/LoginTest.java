package loginTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver webDriver;

    @Before
    public void setUp(){
        File file = new File("./src/old_drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void validLogIn() {


        webDriver.get("http://v3.test.itpmgroup.com");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();

        HomePage homePage = new HomePage(webDriver);


        Assert.assertTrue("Avatar is not present",
                //  webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()
                homePage.isAvatarPresent());


    }

    @Test
    public  void  invalidLogin(){
        webDriver.get("http://v3.test.itpmgroup.com");


        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909070");

        webDriver.findElement(By.tagName("button")).click();

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue("Login form is not shown",
                loginPage.isPasswordFieldPresent());


    }

    @After
    public void
    tearDown(){
        webDriver.quit();
    }

}


