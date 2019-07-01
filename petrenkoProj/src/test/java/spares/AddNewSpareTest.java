package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Petrenko1981" + Utils.getDateAndTimeFormated();
    final String spareType = "Датчики";

    @Test
    public void addNewSpare() {
        loginPage.validLogin();
        homePage.checkIsAvatarDisplaed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.deleteSpareUtilPresent(spareName);


        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown(spareType);
        editSparePage.clickOnButtonCreate();
        checkExpectedResult("Can not find in list", true, sparesPage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare() {
        sparesPage.deleteSpareUtilPresent(spareName);
    }
}
