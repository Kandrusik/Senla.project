package task14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Add {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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

        // add address
        driver.findElement(By.xpath("//a[@data-test='addresses']")).click();
        driver.findElement(By.cssSelector(".justify-content-center")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys("Joe");
        driver.findElement(By.name("address[last_name]")).sendKeys("Black");
        driver.findElement(By.id("address_street_address")).sendKeys("1 Street");
        driver.findElement(By.id("address_secondary_address")).sendKeys("2 Street");
        driver.findElement(By.id("address_city")).sendKeys("Warwick");
        Select city = new Select(driver.findElement(By.cssSelector("#address_state")));
        city.selectByVisibleText("New York");
        driver.findElement(By.name("address[zip_code]")).sendKeys("02889");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("11031975");
        driver.findElement(By.id("address_color")).sendKeys("#FFFF00");
        driver.findElement(By.id("address_age")).sendKeys("46");
        driver.findElement(By.id("address_website")).sendKeys("https://www.kinopoisk.ru/film/5059/");
        driver.findElement(By.id("address_phone")).sendKeys("8(499)391-98-88");
        driver.findElement(By.id("address_interest_read")).click();
//        driver.findElement(By.id("address_picture")).sendKeys("C:\\Users\\Dzmitry\\IdeaProjects\\Senla.project\\src\\test\\java\\task14\\photo.jpg");
        driver.findElement(By.cssSelector("#address_note")).sendKeys("Vot tak vot");
        driver.findElement(By.cssSelector("input[value='Create Address']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}