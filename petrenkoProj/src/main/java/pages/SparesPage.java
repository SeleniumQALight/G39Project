package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;
  //  @FindBy(xpath = ".//*[@name = 'delete']")
  //  private WebElement buttonDelete;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text() ='" + spareName + "']");
    }

    public  void clickOnSpare(String spareName){
        actionsWithOurElements.clickOnElement(".//*[text() ='" + spareName + "']");
    }

    public void deleteSpareUtilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickOnButtonDelete();
            logger.info(spareName + " Was removed");
            if(counter > 100){
                Assert.fail("There are more than 100 spares");
            }
            counter++;
          //  actionsWithOurElements.isElementDisplayed(buttonDelete);
           // actionsWithOurElements.clickOnElement(buttonDelete);
        }

    }
}
