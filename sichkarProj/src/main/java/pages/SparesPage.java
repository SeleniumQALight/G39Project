package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{
      @FindBy(xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;


    public SparesPage(WebDriver webDriver) {

        super(webDriver);
    }


    public void clickOnButtonAdd() {
     actionsWithOurElements.clickOnElement(buttonAdd);
 }


}

