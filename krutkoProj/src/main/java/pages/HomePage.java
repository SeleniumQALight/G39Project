package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy (xpath = ".//li[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy (xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
    @FindBy(xpath = ".//li[@id='prov_cus']")
    private WebElement subMenuDealSides;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent (){
    return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarDisplayed(){
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    public void clickOnDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSubMenuDealSides() {
        actionsWithOurElements.clickOnElement(subMenuDealSides);
    }
}
