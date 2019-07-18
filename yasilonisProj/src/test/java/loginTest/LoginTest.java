package loginTest;

import Pages.HomePage;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/oldDrivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Step
    public void validLogIn() {


        webDriver.get("http://v3.test.itpmgroup.com");
// .\\*[@name='_username']
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("tudent");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue("Avatar is not present",
//                webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()
                homePage.isAvatarPresent()
        );

        webDriver.quit();
    }

    @Test
    public void notValidLogin(){
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("tudent");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        HomePage homePage = new HomePage(webDriver);
        Assert.assertFalse("Avatar is present",
        homePage.isAvatarPresent()
        );
        webDriver.quit();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
