package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    @FindBy (xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }



    public boolean isProviderPrivatePerson(String proCustName, String proCustAddress, String proCustPhone) {
        return actionsWithOurElements.isLineContainText(proCustName,proCustAddress,proCustPhone,"1");
    }



}
