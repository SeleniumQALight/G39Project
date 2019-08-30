package loginTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestToDo {
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
    public void testTodo(){
        webDriver.get("http://learn:javascript@todoappforcurse.herokuapp.com/");

        webDriver.findElement(By.id("create-field")).sendKeys("Hello!!");
        webDriver.findElement(By.xpath(".//*[text()='Edit']")).click();
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("test");
        alert.accept();
        webDriver.switchTo().defaultContent();
        System.out.println("");
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
