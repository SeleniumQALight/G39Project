package loginTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import parentTest.ParentTest;

import javax.naming.ldap.PagedResultsControl;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class loginTestWithPageObject extends ParentTest {
    WebDriver webDriver;
    @Before
    public  void before(){
        File file = new File("./src/newdrivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public  void validLogin(){
        loginPage.openPage();
        HomePage homePage = new HomePage(webDriver);
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar isn't present", homePage.isAvatarPresent());
                //webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()

    }

    @Test
    public  void invalidLogin(){
        loginPage.openPage();
        HomePage homePage = new HomePage(webDriver);
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar isn't present", homePage.isAvatarPresent());
        //webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()

    }

    @After
    public void  after(){
        webDriver.quit();
    }


}
