package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareNames = "DimaY";
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareNames);
     //   editSparePage.selectSpareTypeFromDropDown("Механикa");  // .//*[text()=''] - spareType
        editSparePage.clickOnButtonCreate();
    }
}
