package nopcommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.Random;

public class NopcommRegistration extends Utility {
    String baseURL01 = "https://demo.nopcommerce.com/";

    @Before
    public void openbrowser() {
        chromeDriver();  // chrome driver
        maximizeWindow(); // window maximize method
        implicitWaitSeconds(10); // implicit wait method to wait
        openUrl(baseURL01); //  get method to open url link string
    }
    @Test
    public void registerMe() throws InterruptedException {

        clickOnElement(By.linkText("Register")); // click on register link
        sleepMethod();

        clickOnElement(By.xpath("//span[@class='male']")); // select radio button male

        sendTextToElement(By.id("FirstName"),"Ravikuamar"); // send text to first name field

        sendTextToElement(By.id("LastName"),"Makwana"); // send text to last name field

        clickOnElement(By.xpath("//select[@name='DateOfBirthDay']//option[contains(text(),'11')]"));
        //select date of birth

        clickOnElement(By.xpath("//option[contains(text(),'June')]")); //  select day of birth

        clickOnElement(By.xpath("//option[contains(text(),'1980')]")); //  select year of birth

        WebElement emailField;
        Random email = new Random();
        char c = (char) (email.nextInt(26) + 'a');
        emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(c + "ravee123@gmail.com");

        sendTextToElement(By.id("Company"),"rm testing ltd"); //  send text to company field

        clickOnElement(By.xpath("//input[@id='Newsletter']")); // select radio button for news letter

        sendTextToElement(By.id("Password"),"abdd456"); // send text to password field

        sendTextToElement(By.id("ConfirmPassword"),"abbd456"); //  send text to confirm password field

        clickOnElement(By.id("register-button")); // click on register button to submit

        // verify that registration is completed with welcome text
        String expectedText = "Your registration completed";
        String actualText;
        actualText = (getTextFromElement(By.xpath("//input[@id='register-button']")));
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void closeBrowser() throws InterruptedException {
                sleepMethod();
                quitMethod(); //  quit browser
    }
}

