package task14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Edit {
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

        // Edit address
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(6) > a")).click();

        WebElement address = driver.findElement(By.id("address_street_address"));
        address.clear();
        address.sendKeys("Soviets street");

        WebElement city = driver.findElement(By.id("address_city"));
        city.clear();
        city.sendKeys("Florida");

        Select state = new Select(driver.findElement(By.cssSelector("#address_state")));
        state.selectByVisibleText("Florida");

        WebElement country1 = driver.findElement(By.id("address_country_us"));
        WebElement country2 = driver.findElement(By.id("address_country_canada"));
        if (country1.isSelected()) {
            country2.click();
        } else {
            country1.click();
        }

        WebElement age = driver.findElement(By.id("address_age"));
        age.clear();
        age.sendKeys("45");

        WebElement phone = driver.findElement(By.id("address_phone"));
        phone.clear();
        phone.sendKeys("+357333399890");

        WebElement addressInterest1 = driver.findElement(By.id("address_interest_climb"));
        WebElement addressInterest2 = driver.findElement(By.id("address_interest_dance"));
        WebElement addressInterest3 = driver.findElement(By.id("address_interest_read"));
        if (addressInterest1.isSelected()) {
            addressInterest2.click();
        } else {
            addressInterest3.click();
        }
        if (addressInterest3.isSelected()) {
            addressInterest1.click();
        } else {
            addressInterest2.click();
        }

        driver.findElement(By.cssSelector("input[value='Update Address']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}