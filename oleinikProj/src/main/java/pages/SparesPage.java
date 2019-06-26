package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;
    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement buttonDelete;

    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='"+spareName+"']");
    }

    public void deletSpareUntilPresent(String spareName) {
        while (actionsWithOurElements.isElementDisplayed(".//td[text()='"+spareName+"']")){

            actionsWithOurElements.clickOnElement(".//td[text()='"+spareName+"']");
            actionsWithOurElements.clickOnElement(buttonDelete);

        }
    }
}
