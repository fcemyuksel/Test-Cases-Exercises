package SeleniumJunit.DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown03 {

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
    public void test03() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());

        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);

        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);



        //	4.Tüm dropdown options'i yazdırın
        List<WebElement> tumOpsiyonlar= select.getOptions();
        for (WebElement each: tumOpsiyonlar
        ) {
            System.out.println(each.getText());
        }
        Thread.sleep(1000);

        //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //	degilse False yazdırın.

        int dropdownBoyut= tumOpsiyonlar.size();
        if (dropdownBoyut==4){
            System.out.println("true");
        } else {
            System.out.println("false");
            Assert.assertEquals(3,dropdownBoyut);

        }
        Thread.sleep(1000);

    }

    }

