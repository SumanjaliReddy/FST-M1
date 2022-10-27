package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners()
public class Activity9 {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("User is open to open the application");
    }

    @BeforeMethod
    public void changetodefault(){
        Reporter.log("The user sets the control back to default content");
        driver.switchTo().defaultContent();
    }

    @Test(priority=0)
    public void simpleAlertTestCase(){
        Reporter.log("Starting simple Alert test case");
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple alert opened");
        Alert simpleAlert=driver.switchTo().alert();
        Reporter.log("The control is switched to alert");
        String alertText=simpleAlert.getText();
        Reporter.log("Alert text displayed is : "+alertText);
        Assert.assertEquals(alertText,"This is a JavaScript Alert!","Correct Alert Text is not displayed.");
        simpleAlert.accept();
        Reporter.log("User is able to close the alert successfully");
        }

    @Test(priority=1)
    public void confirmAlertTestCase(){
        Reporter.log("Starting Confirm Alert test case");
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm alert opened");
        Alert confirmAlert=driver.switchTo().alert();
        Reporter.log("The control is switched to alert");
        String alertText=confirmAlert.getText();
        Reporter.log("Alert text displayed is : "+alertText);
        Assert.assertEquals(alertText,"This is a JavaScript Confirmation!","Correct Alert Text is not displayed.");
        confirmAlert.accept();
        Reporter.log("User is able to close the alert successfully");

    }

    @Test(priority=2)
    public void promptAlertTestCase(){
        Reporter.log("Starting Prompt Alert test case");
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt alert opened");
        Alert promptAlert=driver.switchTo().alert();
        Reporter.log("The control is switched to alert");
        String alertText=promptAlert.getText();
        Reporter.log("Alert text displayed is : "+alertText);
        Assert.assertEquals(alertText,"This is a JavaScript Prompt!","Correct Alert Text is not displayed.");
        promptAlert.sendKeys("Awesome");
        Reporter.log("User is able to send message in alert successfully");
        promptAlert.accept();
        Reporter.log("User is able to close the alert successfully");

    }

    @AfterClass
    public void tearDown(){
        Reporter.log("Test case completed.");
        driver.quit();
    }
}