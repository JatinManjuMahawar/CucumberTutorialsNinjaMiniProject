package Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeClickable(WebElement element, int durationInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public WebElement waitForElementToBeVisible(WebElement element, int durationInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public WebElement waitForElementToBeInvisible(WebElement element, int durationInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.invisibilityOf(element));
            return element;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public void clickOnElement(WebElement element, int durationInSeconds) {
        try {
            waitForElementToBeClickable(element, 15);
            element.click();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void sendTextToElement(WebElement element, int durationInSeconds, String textToSend) {
        try {
            waitForElementToBeClickable(element, 15);
            element.click();
            element.clear();
            element.sendKeys(textToSend);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void selectDropdownOptionByText(WebElement element, int durationInSeconds, String textToSend) {
        try {
            waitForElementToBeClickable(element, 15);
            Select select = new Select(element);
            select.selectByVisibleText(textToSend);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public Alert waitForAlert(int durationInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            return alert;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

    public void acceptAlert(int durationInSeconds) {
        try {
            Alert alert = waitForAlert(durationInSeconds);
            alert.accept();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void dismissAlert(int durationInSeconds) {
        try {
            Alert alert = waitForAlert(durationInSeconds);
            alert.dismiss();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public String getAlertText(int durationInSeconds) {
        try {
            Alert alert = waitForAlert(durationInSeconds);
            String alertText = alert.getText();
            return alertText;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
    public void hoverMouseAndPerformAction(int durationInSeconds, WebElement element){
        try {
            waitForElementToBeVisible(element, 20);
            Actions mouseAction = new Actions(driver);
            mouseAction.moveToElement(element).click().build().perform();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public void javaScriptClick(WebElement element, int durationInSeconds){
        waitForElementToBeVisible(element, durationInSeconds);
        JavascriptExecutor jse= ((JavascriptExecutor)driver);
        jse.executeScript("argument[0].click()",element);
    }

    public void javaScriptType(WebElement element, int durationInSeconds, String textToType){
        waitForElementToBeVisible(element, durationInSeconds);
        JavascriptExecutor jse= ((JavascriptExecutor)driver);
        jse.executeScript("argument[0].value='"+textToType+"'",element);
    }

}
