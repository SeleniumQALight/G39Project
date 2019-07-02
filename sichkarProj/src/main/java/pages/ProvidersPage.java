package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver, String partUrl) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String proCustName , String proCustAdress , String proCustPhone) {
        return actionsWithOurElements.isElementDisplayed(
                ".//*[text()='" + proCustName + proCustAdress + proCustPhone + "']");

    }

    public void clickOnProvider(String proCustName , String proCustAdress , String proCustPhone){
        actionsWithOurElements.clickOnElement(".//*[text()='" + proCustName + proCustAdress + proCustPhone + "']");
    }


}