package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase4 {

    WebDriver driver;

    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){driver.quit();}

    @Test
    public void test04() throws InterruptedException {
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
         */

        driver.get("https://automationexercise.com/");
        driver.findElement(By.cssSelector("a[href='/product_details/43']")).click();
        Thread.sleep(2000);
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("cemy@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();


    }
}
