package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {


    @FindBy(xpath = ".//li[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(xpath =".//li[@id='spares']")
    private WebElement SubMenuSpare;
    @FindBy (xpath = ".//*[@class='pull-left image']")
    private  WebElement avatar;
    @FindBy (xpath =".//li[@id='prov_cus']")
    private WebElement SubMenuProviders;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }


    public boolean isAvatarPresent() {
        return ActionsWithOurElements.isElementDisplayed(avatar);

//        try {
//            return avatar.isDisplayed();
//        } catch (Exception e) {
//
//            return false;
//        }

    }

    public void checkIsAvatarDisplayed(){
        Assert.assertTrue("Avatar is not present"
        ,isAvatarPresent());
    }






    public boolean isTextAutorisationPage() {
        try {
            return webDriver.getPageSource().contains("Авторизация");
        } catch (Exception e) {
            return false;
        }


    }

    public void clickOnDictionary() {

        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {

        actionsWithOurElements.clickOnElement(SubMenuSpare);
    }
    public  void  clickOnMenuSubProviders() {
        actionsWithOurElements.clickOnElement(SubMenuProviders);
    }

}
