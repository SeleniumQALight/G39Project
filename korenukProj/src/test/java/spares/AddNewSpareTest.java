package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
final String spareName="koreSpare";

    @Test
    public void addNewSpare(){
        loginPage.validLogin ();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickONSubMenuSpare();

        sparesPage.clickOnButtonAdd();

       editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Механикa");
        editSparePage.clickOnButtonCreate();



    }
}
