package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SparkMain {
    //private WebDriver driver;
    public static void mainpageClients_click_button(WebDriver driver){
        driver.findElement(By.xpath("//a[.='Clients']")).click();

    }

}
