package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = ".//*[@class ='fa fa-plus']")
    WebElement buttonAdd;




    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd(){
        actionWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInLIst(String providerName) {
        return actionWithOurElements.isElementDispalyed(".//*[text()='"+providerName+"']");
    }

    public void clickOnProvider(String providerName){
        actionWithOurElements.clickOnElement(".//*[text()='"+providerName+"']");
    }


    public boolean isProviderAdded(String providerName, String isPrivate){
        WebElement tdElement = webDriver.findElement(By.xpath(".//*[text()='"+providerName+"']/..//span[@class='label label-success']"));
        return tdElement.getText().equals(isPrivate);
    }


    public void deleteProvidersUntilPresent(String providerName) {
        int counter = 0;
        EditSparesPage editProvidersPage = new EditSparesPage(webDriver);
        while(isProviderInLIst(providerName)) {
            clickOnProvider(providerName);
            editProvidersPage.clickOnButtonDelete();
            logger.info(counter+ "Provider was deleted");
            if (counter>100){
                Assert.fail("there are more than 100 providers in list.");
            }
            counter++;
        }
    }
}


