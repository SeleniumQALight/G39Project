package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Chernysh";
    @Test
    public void addNewSpare (){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();
        editSparesPage.enterSpareName(spareName);
       editSparesPage.selectSpareTypeFromDropdown("Механикa");
        editSparesPage.clickOnCreate();
        editSparesPage.findNewElementOnList();

    }
}
