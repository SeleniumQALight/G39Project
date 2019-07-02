package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    int counter;
    @FindBy (xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String proCustName, String proCustAddress, String proCustPhone){
        return actionsWithOurElements.isElementDisplayed(".//tr[.//td[1][text()='"+proCustName+"']" +
                " and .//td[2][text()='"+proCustAddress+"'] " +
                "and .//td[3][text()='"+proCustPhone+"']]");
            }


    public boolean isProviderPrivatePerson(String proCustName, String proCustAddress, String proCustPhone) {
        return actionsWithOurElements.isLineContainText(proCustName,proCustAddress,proCustPhone,"1");

    }


    public void deleteProvidersDuplicateUntilPresent(String proCustName, String proCustAddress, String proCustPhone) {
        counter = 0;
        while (isProviderInList(proCustName,proCustAddress,proCustPhone)){
            EditProvidersPage editProvidersPage = new EditProvidersPage(webDriver);
            clickOnProvider(proCustName,proCustAddress,proCustPhone);
            editProvidersPage.clickOnButtonDelete();
            logger.info("Provider was deleted");
            if (counter>100){
                Assert.fail("There are more then 100 providers in list");
            }
            counter++;
        }

    }

    private void clickOnProvider(String proCustName, String proCustAddress, String proCustPhone) {
        actionsWithOurElements.clickOnElement(".//tr[.//td[1][text()='"+proCustName+"']" +
                " and .//td[2][text()='"+proCustAddress+"'] " +
                "and .//td[3][text()='"+proCustPhone+"']]");
    }
}
