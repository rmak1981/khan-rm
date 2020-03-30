package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class NopCommLogin extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void openBrowser() {
        chromeDriver();
        maximizeWindow();
        implicitWaitSeconds(10);
        openUrl(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {
        clickOnElement(By.linkText("Log in"));
        sleepMethod();
        String expectedText = "Welcome, Please Sign In!";
        String actualText;
        actualText = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
        Assert.assertEquals(expectedText, actualText);
        sendTextToElement(By.xpath("//input[@id='Email']"), "ravee.123@gmail.com");
        sendTextToElement(By.id("Password"), "bac133");
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
    }

    @After
    public void closeBrowser() throws InterruptedException {
        sleepMethod();
        quitMethod();
    }
}
