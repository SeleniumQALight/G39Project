package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent(){
        try {

            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        } catch (Exception e){

            return false;
        }


    }

    public boolean authorizationPage(){
        try {
            return webDriver.findElement(By.xpath(".//div[@class='login-box-body']")).isDisplayed();
        }
        catch (Exception e) {

            return false;


            }
        }
    }


