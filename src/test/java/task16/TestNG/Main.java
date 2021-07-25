package task16.TestNG;

import Utils.Driver;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static task16.Locators.MainLocators.*;


public class Main {

    private final WebDriver driver = Driver.getChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));


    @BeforeClass
    public void beforeClass() {
        driver.get("http://a.testaddressbook.com/");
        Log.info("Authorization on the site");
        driver.findElement(SING_IN).click();
        Log.info("Writing data to fields");
        driver.findElement(SESSION_EMAIL).sendKeys("oleg@www.www");
        driver.findElement(SESSION_PASSWORD).sendKeys("olegmen123");
        Log.info("Click on the authorization button");
        driver.findElement(LOGIN_BUTTON).click();

        Log.info("Метод выполняется перед набором тестов, размещенных в текущем классе");
    }


    @Test(enabled = false)
    public void addAddress() {
        Log.info("Adding address");
        driver.findElement(ADDRESS_BUTTON).click();
        driver.findElement(ADD_ADDRESS).click();
        Log.info("Adding first name");
        driver.findElement(FIRST_NAME).sendKeys("Joe");
        Log.info("Adding last name");
        driver.findElement(LAST_NAME).sendKeys("Black");
        Log.info("Adding address 1");
        driver.findElement(ADDRESS_1).sendKeys("1 Street");
        Log.info("Adding address 2");
        driver.findElement(ADDRESS_2).sendKeys("2 Street");
        Log.info("Adding city");
        driver.findElement(CITY).sendKeys("Warwick");
        Log.info("Adding city");
        Select city = new Select(driver.findElement(STATE));
        city.selectByVisibleText("New York");
        Log.info("Adding zip code");
        driver.findElement(ZIP_CODE).sendKeys("02889");
        Log.info("Adding country US");
        driver.findElement(COUNTRY_US).click();
        Log.info("Adding birthday");
        driver.findElement(BIRTHDAY).sendKeys("11031975");
        Log.info("Adding color");
        driver.findElement(ADDRESS_COLOR).sendKeys("#FFFF00");
        Log.info("Adding age");
        driver.findElement(AGE).sendKeys("46");
        Log.info("Adding website");
        driver.findElement(ADDRESS_WEBSITE).sendKeys("https://www.kinopoisk.ru/film/5059/");
        Log.info("Adding Phone");
        driver.findElement(PHONE).sendKeys("8(499)391-98-88");
        driver.findElement(INTEREST_READ).click();
        Log.info("Adding note");
        driver.findElement(NOTE).sendKeys("Vot tak vot");
        Log.info("Create address");
        driver.findElement(CREATE_ADDRESS).click();
        driver.findElement(ADDRESS_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//h2[contains(text(),'Addresses')]")));
    }


    @Test
    public void editAddress() {
        Log.info("Change address");
        driver.findElement(ADDRESS_BUTTON).click();
        driver.findElement(EDIT_ADDRESS).click();
        Log.info("Change first name");
        driver.findElement(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys("Bogdan");
        Log.info("Change last name");
        driver.findElement(LAST_NAME).clear();
        driver.findElement(LAST_NAME).sendKeys("Glazko");
        Log.info("Change city");
        Select city = new Select(driver.findElement(STATE));
        city.selectByVisibleText("Florida");
        Log.info("Change zip code");
        driver.findElement(ZIP_CODE).clear();
        driver.findElement(ZIP_CODE).sendKeys("230008");
        Log.info("Change color");
        driver.findElement(ADDRESS_COLOR).sendKeys("#FF7F50");
        driver.findElement(INTEREST_READ).click();
        driver.findElement(INTEREST_DANCE).click();
        driver.findElement(INTEREST_CLIMB).click();
        Log.info("Update address");
        driver.findElement(UPDATE_ADDRESS).click();
        driver.findElement(ADDRESS_BUTTON).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//h2[contains(text(),'Addresses')]")));

        assertNotEquals(UPDATE_ADDRESS, ADDRESS_BUTTON);
    }


    @Test
    public void deleteAddress() {
        Log.info("Delete address");
        driver.findElement(ADDRESS_BUTTON).click();
        driver.findElement(DELETE_ADDRESS).click();
        Log.info("Confirm actions");
        driver.switchTo().alert().accept();
    }


    @AfterMethod
    public void goToHome() {
        Log.info("Go to HOME page");
        driver.findElement(HOME_BUTTON).click();
    }


    @AfterClass
    public void exit() {
        Log.info("Sign Out");
        driver.findElement(SING_OUT).click();
        driver.quit();
    }
}
