package parentTest;

import Pages.EditSparePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SparesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    String browser = System.getProperty("browser");

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;
    protected EditSparePage editSparePage;

    @Before
    public void setUp() {
        if (browser==null || "chrome".equals(browser.toLowerCase())) {
            File file = new File("./src/oldDrivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())){
            File file = new File("./src/oldDrivers/geckodriver.exe");
            System.setProperty ("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page",0);
            profile.addPreference("browser.startup.homepage_overdrive.mstone", "ignore");//Suppress the "What's new" page
            webDriver = new FirefoxDriver();
        }
//        else if ("iedriver".equals(browser)) {
//            File file1 = new File("./src/oldDrivers/IEDriverServer.exe");
//            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
//            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//            capabilities.setCapability("ignoreZoomSetting", true);
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            webDriver = new InternetExplorerDriver();
//        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
        editSparePage = new EditSparePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean expectedResult
            , boolean actualResult){
        Assert.assertEquals(message, expectedResult, actualResult);
    }
//    public void checkExpectedResult (String message, boolean actualResult){
//        checkExpectedResult();
//    }


}
