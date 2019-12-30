package TestCases;

import PageObjects.SparkMain;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testSpark {

    public class TestAutomation {
        private WebDriver driver;

        @BeforeClass
        @Parameters({"URL", "BrowserType"})
        public void iniConf(String url, String browserType) {
            if (browserType.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browserType.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();


            } else if (browserType.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();


            }
            driver.get(url);
            System.out.println("Opening" + browserType);

        }

        @AfterClass
        public void closeSession()  {
            //Thread.sleep(2000);
            //driver.close();
            driver.quit();
        }

        @Test
        public void sparkTest() {
            SparkMain.mainpageClients_click_button(driver);

            WebElement thirdItem = driver.findElement(By.xpath("//li[contains(.,'Deluxe')]"));
            Actions builder = new Actions(driver);
            Action mousetoElement = builder.moveToElement(thirdItem).build();
            mousetoElement.perform();
            String thirdElemnt = driver.findElement(By.xpath("//li[contains(.,'Deluxe')]")).getText();
            Assert.assertEquals(thirdElemnt, "Deluxe");
            System.out.println("el test fue " + "\n" + "bonito");

        }
    }
}
