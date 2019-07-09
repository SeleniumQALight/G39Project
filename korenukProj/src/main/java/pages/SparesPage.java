package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class SparesPage extends ParentPage{


   @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/");
    }

    public void checkCurrentUrl() {

        try {
            String myexpectedUrl = BASE_URL + "/dictionary/spares";
            logger.info("SparesPage expectedUrl:");
            logger.info(myexpectedUrl);
            logger.info("SparesPage getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(myexpectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }
    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void clickOnSpare(String spareName){
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }

    public void deletSpareUntilPresent(String spareName) {
        int counter=0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickOnButtonDelete();
            logger.info("Spare was deleted");
            if (counter >100){
                Assert.fail("There are more than 100 spares");
            }
            counter ++;
        }
    }
        }



