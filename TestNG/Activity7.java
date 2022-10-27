package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

@Listeners()
public class Activity7 {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] loginCredentials() {
        return new Object[][] { { "admin", "password" }};
    }
    @Test(dataProvider = "Authentication")
    public void LoginTestWithDataProvider(String username, String password) throws InterruptedException{
        String title =  driver.getTitle();
        Assert.assertEquals("Login Form",title,"The title is not Login Form.");
        Reporter.log("User is able to open the form successfully");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin","Welcome message is not displayed.");
        Reporter.log("User is able to login using credentials from dataProvider.");
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}