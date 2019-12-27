package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class Test1 {
      private WebDriver driver;

 @BeforeClass

    public void iniConf(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

 @AfterClass
    public void closeSession() throws InterruptedException {
     Thread.sleep(5000);
     driver.close();
     driver.quit();
 }

 @Test (priority = 0, description = "This is a simple search in Google")
    public void makeaSearch(){
     driver.get("https://www.google.com");
     driver.findElement(By.name("q")).sendKeys("selemnium");
     /*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     WebDriverWait wait = new WebDriverWait(driver, 30);
     WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ID")));*/


 }
}
