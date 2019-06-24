package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePages;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
   protected LoginPage loginPage;
    protected HomePages homePages;
    @Before
    public void setUp(){
        File file = new File("./src/old_drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver  = new ChromeDriver();


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePages = new HomePages(webDriver);

    }
    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean expectedResult,
                                    boolean actualResult){
        Assert.assertEquals(message, expectedResult, actualResult);
    }
  //  public void checkExpectedResult(String mesaage, boolean actualResult){
   //     checkExpectedResult();
  //  }

}
