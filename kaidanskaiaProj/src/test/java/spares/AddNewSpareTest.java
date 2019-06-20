package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "Keidanska@//";
    @Test
    public void addNewSpare(){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

//        sparesPage.clickOnButtonAdd();
//        editSparePage.enterSpareName(spareName); //HW
//        editSparePage.selectSpareTypeFromDropDown("Механикa");//HW find dropdown, open, find element and click
//        editSparePage.clickOnButtonCreate(); //HW






    }
}
