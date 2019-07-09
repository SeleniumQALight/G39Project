package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "DimaY_+ Utils.getDateAndTimeFormated()";
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deleteSpareUtilPresent(spareName);
        sparesPage.clickOnButtonAdd();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Механикa");  // .//*[text()=''] - spareType selectTextInDDByJava
        editSparePage.clickOnButtonCreate();

        sparesPage.checkCurrentUrl();

        checkExpectedResult("Can not find spare in list"
            ,true
            ,sparesPage.isSpareInList(spareName));
        }
        @After
    public void deleteSpare(){
        sparesPage.deleteSpareUtilPresent(spareName);
        }
}
