package pages;

import libs.ActionsWithOutElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy (xpath = ".//li[@id='dictionary']")
    private WebElement menuDictionary;
    @FindBy (xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent(){
        try{
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    public void clickOnDictionary() {
        actionsWithOutElements.clickOnElement (menuDictionary);

    }

    public void clickOnSubMenuSpare() {
        actionsWithOutElements.clickOnElement(subMenuSpare);

    }
}
