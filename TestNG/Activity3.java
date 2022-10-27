package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners()
public class Activity3 {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void act1(){
        String title =  driver.getTitle();
        Assert.assertEquals("Login Form",title,"The title is not Login Form");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String newTitle= driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals( newTitle,"Welcome Back, admin","The correct welcome message is not displayed.");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}