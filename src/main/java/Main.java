import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        WebDriver driver = initChromeDriver();
        //WebElement element;

        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Pause();

        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();

        Pause();
        List<WebElement> menuElements = driver.findElements(By.className("maintab"));

        for (WebElement element:menuElements
               ) {

            //WebDriverWait wait = new WebDriverWait(driver, 5);
           // wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println(element.getText());
            element.click();
            Pause();
            
            driver.navigate().refresh();
            Pause();
        }

    }

    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    public static void Pause(){
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
