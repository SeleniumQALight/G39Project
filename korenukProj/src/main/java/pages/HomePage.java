package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//li[@id='dictionary']/a")
            private WebElement menuDicionary;
    @FindBy(xpath = ".//li[@id='spares']")


    private WebElement subMenuSpare;

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

    public void clickOnDictionary() {
        actionsWithOurElements.clickOnElement(menuDicionary);
    }

    public void clickONSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}


