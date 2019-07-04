package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver ) {

        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String proCustName) {
        return actionsWithOurElements.isElementDisplayed(
                ".//*[text()='" + proCustName +  "']");

    }

    public void clickOnProvider(String proCustName){
        actionsWithOurElements.clickOnElement(".//*[text()='" + proCustName  + "']");
    }

    public void deliteProviderUntilPresent(String proCustName) {
        int counter = 0;

        EditProvidersPage editProvidersPage = new EditProvidersPage(webDriver);
        while (isProviderInList(proCustName)) {
            clickOnProvider(proCustName);
            editProvidersPage.checkCurrentUrl();
            editProvidersPage.clickOnButtonDelete();
            logger.info( " Provider was deleted" );
            if(counter > 100) {
                Assert.fail("There are more than 100 Providers.");
            }
            counter++;
        }
    }

}