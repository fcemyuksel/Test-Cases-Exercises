package SeleniumJunit.ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass01MouseHover {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
        WebElement languageSelection = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']"));
        actions.moveToElement(languageSelection).perform();
        driver.findElement(By.xpath("//a[@href='#switch-lang=de_DE']")).click();
        Thread.sleep(5000);

        WebElement languageSelection2 = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']"));
        actions.moveToElement(languageSelection2).perform();
        driver.findElement(By.xpath("//a[@href='#switch-lang=en_US']")).click();
        Thread.sleep(5000);
    }
}
