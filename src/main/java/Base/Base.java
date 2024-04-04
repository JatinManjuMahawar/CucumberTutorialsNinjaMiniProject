package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop = new Properties();

    public static WebDriverWait getShortWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
    public static WebDriverWait getMediumWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }
    public static WebDriverWait getLongWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait;
    }
    public static WebDriverWait getVeryLongWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        return wait;
    }

    public static void waitUntilElementIsClickable(String xPATH){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPATH)));
    }
    public static void waitUntilElementIsSelectable(String xPATH){
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xPATH)));
    }
    public static void waitUntilAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public static void waitUntilElementIsClickable(WebElement element, String getWaitDuration){
        if(getWaitDuration.equalsIgnoreCase("short")){
            wait = getShortWait();
        }
        else if(getWaitDuration.equalsIgnoreCase("medium")){
            wait = getMediumWait();
        }
        else if(getWaitDuration.equalsIgnoreCase("long")){
            wait = getLongWait();
        }
        else if(getWaitDuration.equalsIgnoreCase("verylong")){
            wait = getVeryLongWait();
        }
        else{
            wait = getShortWait();
        }
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Properties getPropertiesConfiguration() throws Exception {
        File propertyFile = new File("src\\main\\java\\Config\\config.properties");
        FileInputStream fis = new FileInputStream(propertyFile);
        prop.load(fis);
        return prop;
    }

    public static WebDriver initializeBrowser(String browserName) throws Exception {
        if(browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("FireFox")){
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }
        else{
            driver = new ChromeDriver();
        }
        Properties prop = getPropertiesConfiguration();
        driver.get(prop.getProperty("BaseURL"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
