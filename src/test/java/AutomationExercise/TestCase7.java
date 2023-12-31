package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase7 {

    WebDriver driver;

    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){driver.quit();
        }

    @Test
    public void test06() throws InterruptedException {

/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
             */



        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//p[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")).click();
        Thread.sleep(2000);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
        Thread.sleep(2000);
        driver.get("https://automationexercise.com/test_cases");
        driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).isDisplayed();

    }

    }

