package loginTest;

import pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class loginTest {
    WebDriver webDriver;
    @Before
    public  void before(){
        File file = new File("./src/newdrivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*
        @Test
        public void validLoginIn (){
            webDriver.get("http://v3.test.itpmgroup.com/");

            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys("Student");
            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys("909090");
            webDriver.findElement(By.tagName("button")).click();

            HomePage homePage = new HomePage(webDriver);

            Assert.assertTrue("Avatar isn't present", homePage.isAvatarPresent()
                    //webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()
            );
        }
    */
    @After
    public void  after(){
        webDriver.quit();
    }
}
