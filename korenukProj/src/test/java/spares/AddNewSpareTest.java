package spares;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
final String spareName="koreSpare_"+ Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpare(){
        loginPage.validLogin ();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickONSubMenuSpare();

        sparesPage.checkCurrentUrl();
        sparesPage.deletSpareUntilPresent(spareName);

        sparesPage.clickOnButtonAdd();

       editSparePage.checkCurrentUrl();
       editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Механикa");
        editSparePage.clickOnButtonCreate();


        checkExpectedResult("Can not find editSparePage.checkCurrentUrl();spare in list",true,sparesPage.isSpareInList(spareName));


    }
    @After
    public void deleteSpare(){
        sparesPage.deletSpareUntilPresent(spareName);

    }

}
