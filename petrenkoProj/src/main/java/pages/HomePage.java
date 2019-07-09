package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//li[@id = 'dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(xpath = ".//li[@id='spares']")
    private WebElement subMenuSpare;

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
    @FindBy(xpath =".//li[@id = 'prov_cus']/a" )
    private WebElement subMenuProvider;

    public HomePage(WebDriver webDriver) {
        super(webDriver,"/");
    }

    public boolean isAvatarPresent() {

        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarDisplaed() {
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    public void clickOnDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);

    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSubMenuProvider() {
        actionsWithOurElements.clickOnElement(subMenuProvider);
    }

}
