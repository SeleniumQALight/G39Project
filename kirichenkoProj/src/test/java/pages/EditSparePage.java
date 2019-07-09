package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {


    @FindBy(id = "spares_spareName")
    private WebElement inputspareName;
    @FindBy(name = "add")
    private WebElement add;
    @FindBy(id = "spares_spareType")
    private WebElement spareDD;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit(|/\\d{1,})");
    }


   // public static void selectSpareTypeFromDropDown(String spareType) {
 //       actionsWithOurElements.selectedTextInDD(
  //              typeDD, spareType);



   // }

   public void enterSpareName(String spareName) {
       actionsWithOurElements.enterTextInToInput(inputspareName, spareName);
    }

    public  void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(add);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectTextInDD(spareDD, spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

