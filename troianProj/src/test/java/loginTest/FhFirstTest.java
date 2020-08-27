package loginTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FhFirstTest {

    WebDriver webDriver;
    //Precondition
    @Before
    public void setUp(){
        File file = new File("./src/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
    @Test

    public void validLogin(){


        webDriver.get("https://uat.fleethand.com/");



    }
    //Postcondition
    @After
    public void tearDown(){
        webDriver.quit();
    }
}