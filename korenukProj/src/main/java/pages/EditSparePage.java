package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class EditSparePage extends ParentPage {

   @FindBy(xpath=".//select[@id='spares_spareType']")
   private WebElement typeDD;
    @FindBy(xpath=".//input[@id='spares_spareName']")
    private WebElement createName;
    @FindBy(xpath=".//button[@name='add']")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement deleteButton;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(typeDD,spareType);
    }

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterTextIntoInput(createName,spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }

    public void checkCurrentUrl() {

        try {
            String myexpectedUrl = BASE_URL + "/dictionary/spares/edit";
            logger.info("EditSparesPage expectedUrl:");
            logger.info(myexpectedUrl);
            logger.info("EditSparesPage getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(myexpectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
}}



