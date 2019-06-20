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

    @Test
    public  void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not pressent", true, homePage.isAvatarPresent());
    }

    @Test
    public  void invalidLogin(){
        loginPage.openPage();
        HomePage homePage = new HomePage(webDriver);
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("000000");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertFalse("Avatar isn't present", homePage.isAvatarPresent());
        //webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()
    }

}
