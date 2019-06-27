package pages;

import libs.ActionsWithOutElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//li[@id='dictionary']")
    private WebElement menuDictionary;
    @FindBy(xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOutElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarDisplayed() {
        Assert.assertTrue("Avatar isn't present", isAvatarPresent());
    }

    public void clickOnDictionary() {
        actionsWithOutElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOutElements.clickOnElement(subMenuSpare);

    }
}
