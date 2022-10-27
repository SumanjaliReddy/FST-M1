package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class Activity5 {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void titleTest(){
        String title =  driver.getTitle();
        Assert.assertEquals("Target Practice",title,"The title is not Target Practice");
    }

    @Test(groups = {"HeaderTests"})
    public void header1Test(){
        WebElement element = driver.findElement(By.id("third-header"));
        Assert.assertEquals(element.getText(),"Third header","The header is not displayed correctly");

    }

    @Test(groups = {"HeaderTests"})
    public void header2Test(){
        WebElement element = driver.findElement(By.xpath("//h5[@class='ui green header']"));
        Assert.assertEquals(element.getCssValue("color"), "rgb(33, 186, 69)","The header colour is not displayed correctly");

    }

    @Test(groups = {"ButtonTests"})
    public void button1Test(){
        WebElement element = driver.findElement(By.xpath("//button[@class='ui olive button']"));
        Assert.assertEquals(element.getText(), "Olive","The button text is not displayed correctly");

    }

    @Test(groups = {"ButtonTests"})
    public void button2Test(){
        WebElement element = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(element.getCssValue("color"), "rgb(255, 255, 255)","The button colour is not displayed correctly");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}