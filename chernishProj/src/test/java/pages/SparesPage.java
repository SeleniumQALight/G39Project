package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{
    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver)
    {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonAdd() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }


    public boolean isSpareInList(String spareName) {
        return actionWithOurElements.isElementDispalyed(".//*[text()='"+spareName+"']");
    }

    public void clickOnSpare(String spareName){
        actionWithOurElements.clickOnElement(".//*[text()='"+spareName+"']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparesPage editSparesPage = new EditSparesPage(webDriver);
        while(isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparesPage.clickOnButtonDelete();
            logger.info(counter+ "Spare was deleted");
            if (counter>100){
                Assert.fail("there are more than 100 spares in list.");
            }
            counter++;
        }
    }
}
