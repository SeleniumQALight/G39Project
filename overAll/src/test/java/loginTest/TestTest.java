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
import java.util.regex.Pattern;

public class TestTest {

    @Test
    public void validLogIn(){
        System.out.println(Pattern.matches("http://v3.test.itpmgroup.com/dictionary/spares/edit(/\\d{1,}|)", "http://v3.test.itpmgroup.com/dictionary/spares/edit"));
    }


}
