package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonAdd() {
        actionsWithOutElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOutElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void clickSpare (String spareName){
        actionsWithOutElements.clickOnElement(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntillPresent(String spareName) {
        int counter=0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)) {
           clickSpare(spareName);
            editSparePage.clickOnButtonDelete();
            logger.info(counter + "Spare was deleted");
            if (counter>100){
                Assert.fail("There are were more than 100 spares");
            }
            counter++;
        }
    }
}
