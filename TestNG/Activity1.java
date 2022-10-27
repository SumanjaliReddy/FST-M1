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
public class Activity1 {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void act1(){
        String title =  driver.getTitle();
        Assert.assertEquals("Training Support",title,"The title is not Training Support");
        driver.findElement(By.id("about-link")).click();
        String newTitle= driver.getTitle();
        Reporter.log("The new title of the page is "+newTitle
        );
        System.out.println("The new title of the page is "+newTitle);
        Assert.assertEquals("About Training Support",newTitle,"The new title of teh pae is not correct");


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}