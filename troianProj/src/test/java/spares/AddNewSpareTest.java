package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "TroianSpare";
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDicitionary();
        homePage.clickOnSubmenuSpare();

        sparesPage.clickOnButtonAdd();
//        editSparePage.enterSpareName(spareName);
//        editSparePage.selectSpareTypeFromDropDpwn("Механикa");
//        editSparePage.clickOnButtonCreate();


    }
}
