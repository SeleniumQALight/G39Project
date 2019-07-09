package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOutElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String proCustName) {
        if (actionsWithOutElements.isElementDisplayed(".//td[text()='" + proCustName + "']") == true){
             //   && actionsWithOutElements.isElementDisplayed(".//td[text()=" + proCustAddress + "']") == true
             // && actionsWithOutElements.isElementDisplayed(".//td[text()=" + proCustPhone + "']") == true) {
            logger.info("Provider is present");
            return true;
        }   else
            logger.error("Provider wasn't finded");
            return false;
        }

       /* if (actionsWithOutElements.isElementDisplayed(".//td[text()=" + proCustName + "']") == true  ) {
            logger.info("proCustName was finded");
            if (actionsWithOutElements.isElementDisplayed(".//td[text()='" + proCustAddress + "']") == true) {
                logger.info("proCustAddres was finded");
                if (actionsWithOutElements.isElementDisplayed(".//td[text()='" + proCustPhone + "']") == true) {
                    logger.info("proCustPhone was finded");
                    return true;
                } else logger.info("proCustPhone wasn't finded");
                return false;
            } else logger.info("proCustAddres wasn't finded");
            return false;
        } else logger.info("proCustname wasn't finded");
        return false;*/


    public boolean isProvidersNameInList(String proCustName) {
        return actionsWithOutElements.isElementDisplayed(".//*[text()='" + proCustName + "']");


    }



/*
    public void deleteProvidersUntillPresent(String proCustName) {
        int counter=0;
        EditProviderPage editProviderPage = new EditProviderPage(webDriver);
        while (isSpareInList(proCustName)) {
            clickSpare(spareName);
            editSparePage.clickOnButtonDelete();
            logger.info(counter + "Spare was deleted");
            if (counter>100){
                Assert.fail("There are were more than 100 spares");
            }
            counter++;
        }
    }


    public boolean isSpareInList(String proCustName) {
        return actionsWithOutElements.isElementDisplayed(".//*[text()='" + proCustName + "']");
    }

 */


}
