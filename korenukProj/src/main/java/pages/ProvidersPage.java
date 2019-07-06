package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class ProvidersPage extends ParentPage {
        @FindBy(xpath = "//i[@class='fa fa-plus']")
        private WebElement buttonAdd;

        public ProvidersPage(WebDriver webDriver) {

            super(webDriver, "/dictionary/providers/");
        }
        public void checkCurrentUrl() {
            logger.info("ProvidersPage expectedUrl:");
            /*
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
        }*/
    }
        public void clickOnButtonAdd() {
            actionsWithOurElements.clickOnElement(buttonAdd);
        }

    }

