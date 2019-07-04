package deal_sides;

import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewCustTest extends ParentTest {
    final String custName = "Krutko " + Utils.getDateAndTimeFormated();
    final String custAddress = "Walt Street " + Utils.getDateAndTimeFormated();
    final String custPhone = "000000 " + Utils.getDateAndTimeFormated();

    @Test
    public void addNewCust() {
        loginPage.validLogin();
        homePage.checkIsAvatarDisplayed();
        homePage.clickOnDictionary();
        homePage.clickOnSubMenuDealSides();

        dealSidesPage.clickOnButtonAdd();
        editCustPage.enterCustName(custName);
        editCustPage.enterCustAddress(custAddress);
        editCustPage.enterCustPhone(custPhone);
        editCustPage.checkOnPrivate();
        editCustPage.checkOnFirm();
        editCustPage.clickOnbuttonCreate();

        dealSidesPage.clickOnButtonAdd();
        editCustPage.enterCustName(custName);
        editCustPage.enterCustAddress(custAddress);
        editCustPage.enterCustPhone(custPhone);
        //editCustPage.checkboxPrivate();
        //editCustPage.checkboxFirm();
        editCustPage.clickOnbuttonCreate();

        dealSidesPage.clickOnButtonAdd();
        editCustPage.enterCustName(custName);
        editCustPage.enterCustAddress(custAddress);
        editCustPage.enterCustPhone(custPhone);
        editCustPage.checkOnFirm();
        editCustPage.clickOnbuttonCreate();




    }
    @After
    public void deleteCust() {
        dealSidesPage.deleteCustUntilPresent(custName);
    }
}
