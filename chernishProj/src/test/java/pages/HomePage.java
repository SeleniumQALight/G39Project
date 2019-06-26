package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  ParentPage{


    @FindBy (xpath = ".//li[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy (xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;

    @FindBy (xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent(){
        return actionWithOurElements.isElementDispalyed(avatar);

    }

    public void checkIsAvatarDisplayed(){
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    public void clickOnDictionary() {
        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionWithOurElements.clickOnElement(subMenuSpare);

    }



}
