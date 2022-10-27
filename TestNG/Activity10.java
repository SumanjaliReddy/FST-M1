package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners()
public class Activity10 {

    private WebDriver driver;
    Actions action;

    @BeforeClass
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/sliders");
        action = new Actions(driver);
        Reporter.log("User is open to open the application");
    }

    @Test(priority=0)
    public void middleSliderTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        String volumeText = driver.findElement(By.xpath("//span[@id='value']")).getText();
        Assert.assertEquals(volumeText,"50","The slider is not at max");
        Reporter.log("The slider moves to the middle point successfully.");
    }

    @Test(priority=1)
    public void maxValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        String maxVolumeText=driver.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("The max volume text is"+maxVolumeText);
        Assert.assertEquals(maxVolumeText,"100","The slider is not at middle");
        Reporter.log("The slider moves to the maximum point successfully.");

    }
    @Test(priority=2)
    public void minValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        String minVolumeText=driver.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("The min volume text is"+minVolumeText);
        Assert.assertEquals(minVolumeText,"0","The slider is not at min");
        Reporter.log("The slider moves to the min point successfully.");

    }

    @Test(priority=3)
    public void ThirtypercentSliderTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        String VolumeText=driver.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("The 30% volume text is"+VolumeText);
        Assert.assertEquals(VolumeText,"30","The slider is not at 30");
        Reporter.log("The slider moves to the 30% successfully.");


    }

    @Test(priority=4)
    public void EightypercentSliderTest() throws InterruptedException{
        WebElement slider = driver.findElement(By.id("slider"));
        action.clickAndHold(slider).moveByOffset(44, 0).release().build().perform();
        Thread.sleep(2000);
        String VolumeText=driver.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("The 80% volume text is"+VolumeText);
        Assert.assertEquals(VolumeText,"80","The slider is not at 80%");
        Reporter.log("The slider moves to the 80% successfully.");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}