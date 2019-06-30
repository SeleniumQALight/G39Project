package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public ProvidersPage (WebDriver webDriver){
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd (){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }


    public void deleteProvidersUntilPresent(String providerName) {
        int current = 0;
        EditProvidersPage editProvidersPage = new EditProvidersPage(webDriver);
        while (isProviderInList(providerName)){
            clickOnProvider(providerName);
            editProvidersPage.clickOnButtonDelete();
            logger.info((current +1) + " " + "Provider was deleted");
            if (current > 50){
                Assert.fail("There are more than 100 spares. ");
            }
            current++;
        }
    }

    public boolean isProviderInList(String providerName) {
        return actionsWithOurElements.isElementDisplayed(".//td[text()='" + providerName + "']");
    }

    public void clickOnProvider(String providerName) {
        actionsWithOurElements.clickOnElement(".//td[text()='" + providerName + "']");
    }
}
