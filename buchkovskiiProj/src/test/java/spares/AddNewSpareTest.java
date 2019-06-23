package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String spareName = "BuchkivskyiSpare";
    @Test
    public void addNewSpare (){
        loginPage.validLogin();
        homePage.isAvatarPresent();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuSpare();

        sparesPage.clickOnButtonAdd();
     //   editSparePage.enterSpareName(spareName);  //Homework
        editSparePage.selectSpareTypeFromDropdown("Механикa"); //Homework:  4 action
    //     editSparePage.clickOnButtonCreate(); //Homework



    }


}
