package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void act1(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice", "The title is not correct");
    }

    @Test
    public void act2(){
        WebElement element = driver.findElement(By.xpath("//button[@class='ui black button']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),"Yellow","The element is not correct");
    }

    @Test(enabled = false)
    public void act3(){
        System.out.println("This method is skipped");
    }

    @Test
    public void act4(){
        throw new SkipException("Skip the test");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}