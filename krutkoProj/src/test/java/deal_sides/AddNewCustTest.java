package deal_sides;

import libs.Utils;
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

        Utils.waitABit(10);

        dealSidesPage.clickOnButtonAdd();
        editCustPage.enterCustName(custName);
        editCustPage.enterCustAddress(custAddress);
        editCustPage.enterCustPhone(custPhone);

        editCustPage.checkOnPrivate();
        editCustPage.checkOnFirm();
        editCustPage.clickOnbuttonCreate();

    }
}
