package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;
    protected EditSparesPage editSparesPage;
    protected ProvidersPage providersPage;
    protected pages.editProvidersPage editProvidersPage;

    @Before
    public void setUp(){
        if (browser==null ||"chrome".equals(browser.toLowerCase())){

        File file = new File("./src/prevdriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();
        }else if("firefox".equals(browser.toLowerCase())){
            File file = new File("./src/prevdriver/geckodriver-v0.24.0-macos");
            System.setProperty ("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page",0);
            profile.addPreference("browser.startup.homepage_overdrive.mstone", "ignore");//Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
        editSparesPage = new EditSparesPage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        editProvidersPage = new editProvidersPage(webDriver);


    }

    @After
    public void tearDown(){

        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean expectedResult, boolean actualResult){
        Assert.assertEquals(message, expectedResult, actualResult);
    }

/*    public void checkExpectedResult(String message, boolean actualResult){
        checkExpectedResult();
    }*/

}
