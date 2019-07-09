package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");

    }

    public void clickOnButtonAdd() {

        try {
            actionsWithOurElements.clickOnElement(buttonAdd);
        } catch (Exception e) {

            logger.info("erro>r" + e.getMessage());
        }
    }


    public void checkCurrentUrl() {
        logger.info("ProvidersPage expectedUrl:");

        try {
            String myexpectedUrl = BASE_URL + "/dictionary/providers";
            logger.info("ProvidersPage expectedUrl:");
            logger.info(myexpectedUrl);
            logger.info("ProvidersPage getCurrentUrl:");
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("Url is not expected", Pattern.matches(myexpectedUrl, webDriver.getCurrentUrl()), true);
        } catch (Exception e) {
            logger.error("Can not get url" + e);
            Assert.fail("Can not get url");
        }
    }
}



