package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private Button buttonAdd;

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
        return actionsWithOurElements.isElementDisplayed(
                ".//td[text()='" + providerName + "']");
    }

    public void clickOnProvider(String providerName) {
        actionsWithOurElements.clickOnElement(".//td[text()='" + providerName + "']");
    }

    public void checkLablPrivatePerson(String provaiderName) {
        Assert.assertEquals("Label physical person not installed","1",
                webDriver.findElement(By.xpath
                (".//tr[td='" + provaiderName + "' and td='My_address' and td='My_phone']//td[4]")).getText());
    }

    public void checkLablIsOurFirm(String provaiderName) {
        Assert.assertEquals("Label is our firm not installed","",webDriver.findElement(By.xpath
                (".//tr[td='" + provaiderName + "' and td='My_address' and td='My_phone']//td[4]")).getText());
    }
}
