package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testSpark {

    public class TestAutomation {
        private WebDriver driver;

        @BeforeClass

        public void iniConf(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @AfterClass
        public void closeSession() throws InterruptedException {
            Thread.sleep(2000);
            driver.close();
            driver.quit();
        }

        @Test
                public void sparkTest()
        {
            driver.get("https://sparkdigital.com/");
            driver.findElement(By.xpath("//a[.='Clients']")).click();
            String  thirdElemnt = driver.findElement(By.xpath("//li[contains(.,'Deluxe')]")).getText();
            System.out.println("El tercer Elemento es : " + thirdElemnt);




        }
    }}
