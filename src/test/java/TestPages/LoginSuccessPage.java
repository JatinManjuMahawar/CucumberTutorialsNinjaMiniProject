package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSuccessPage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//*[text()='Edit your account information']")
    private WebElement loginVerifySuccessfulLogin;

    public Boolean VerifySuccessfulLogin(){
        Boolean isLoginSuccessful = false;
        try{
            isLoginSuccessful = loginVerifySuccessfulLogin.isDisplayed();}
        catch(Exception ex){
        }
        return isLoginSuccessful;
    }




}
