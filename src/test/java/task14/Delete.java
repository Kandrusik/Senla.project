package task14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Delete {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();
        driver.findElement(By.id("session_email")).sendKeys("oleg@www.www");
        driver.findElement(By.name("session[password]")).sendKeys("olegmen123");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(2000);

        // delete address
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(5000);
        driver.quit();
    }
}