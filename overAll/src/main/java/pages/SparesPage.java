package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver,"/dictionary/spares");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(
                ".//*[text()='"+spareName+"']");
    }

    public void clickOnSpare(String spareName){
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }

    public void deletSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.checkCurrentUrl();
            editSparePage.clickOnButtonDelete();
            logger.info(counter + " Spare was deletted");
            if (counter > 100){
                Assert.fail("There are more than 100 spares. ");
            }
            counter++;
        }
    }
}
