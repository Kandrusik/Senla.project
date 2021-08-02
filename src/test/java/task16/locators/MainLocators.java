package task16.locators;

import org.openqa.selenium.By;

public class MainLocators {

    // Sing In
    public static final By SING_IN = By.id("sign-in");
    public static final By SESSION_EMAIL = By.id("session_email");
    public static final By SESSION_PASSWORD = By.name("session[password]");
    public static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");

    // Sing Out
    public static final By SING_OUT = By.cssSelector("a[data-test='sign-out']");

    // Address
   public static final By ADDRESS_BUTTON = By.xpath("//a[@data-test='addresses']");
   public static final By ADD_ADDRESS = By.cssSelector(".justify-content-center");
   public static final By EDIT_ADDRESS = By.cssSelector("tr:nth-child(1) > td:nth-child(6) > a");
   public static final By FIRST_NAME = By.name("address[first_name]");
   public static final By LAST_NAME = By.name("address[last_name]");
   public static final By ADDRESS_1 = By.id("address_street_address");
   public static final By ADDRESS_2 = By.id("address_secondary_address");
   public static final By CITY = By.id("address_city");
   public static final By STATE = By.cssSelector("#address_state");
   public static final By ZIP_CODE = By.name("address[zip_code]");
   public static final By COUNTRY_US = By.id("address_country_us");
   public static final By BIRTHDAY = By.name("address[birthday]");
   public static final By ADDRESS_COLOR = By.id("address_color");
   public static final By AGE = By.id("address_age");
   public static final By ADDRESS_WEBSITE = By.id("address_website");
   public static final By PHONE = By.id("address_phone");
   public static final By NOTE = By.cssSelector("#address_note");
   public static final By INTEREST_CLIMB = By.id("address_interest_climb");
   public static final By INTEREST_DANCE = By.id("address_interest_dance");
   public static final By INTEREST_READ = By.id("address_interest_read");
   public static final By CREATE_ADDRESS = By.cssSelector("input[value='Create Address']");
   public static final By UPDATE_ADDRESS = By.cssSelector("input[value='Update Address']");
   public static final By DELETE_ADDRESS = By.cssSelector("tr:nth-child(1) > td:nth-child(7) > a");


   // Home
   public static final By HOME_BUTTON = By.cssSelector("a.nav-link.active");
}