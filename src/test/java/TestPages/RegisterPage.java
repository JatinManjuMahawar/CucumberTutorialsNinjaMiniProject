package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class RegisterPage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//span[@class='caret']")
    private WebElement registerMyAccountDropdown;
    @FindBy(xpath = "//ul//li//a[text()='Register']")
    private WebElement registerRegisterButton;
    @FindBy(xpath = "//*[@name='firstname']")
    private WebElement registerFirstname;
    @FindBy(xpath = "//*[@name='lastname']")
    private WebElement registerLastname;
    @FindBy(xpath = "//*[@name='email']")
    private WebElement registerEmail;
    @FindBy(xpath = "//*[@name='telephone']")
    private WebElement registerTelephone;
    @FindBy(xpath = "//*[@id='input-password']")
    private WebElement registerPassword;
    @FindBy(xpath = "//*[@id='input-confirm']")
    private WebElement registerConfirmPassword;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    private WebElement registerSubscribeNewsletter;
    @FindBy(xpath = "//input[@type='checkbox'][@name='agree']")
    private WebElement registerPrivacyPolicyCheckbox;
    @FindBy(xpath = "//input[@type='submit'][@class='btn btn-primary']")
    private WebElement registerSubmitRegistrationDetailsButton;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement registerPrivacyPolicyButton;
    @FindBy(xpath = "//i[@class='fa fa-exclamation-circle']")
    private WebElement registerPageWarningMessage;
    @FindBy(xpath = "//i[@class='fa fa-exclamation-circle']")
    private WebElement registerFieldWarningMessage;

    public void clickOnMyAccountDropdown(){
        registerMyAccountDropdown.click();
    }
    public void clickOnRegisterOption(){
        registerRegisterButton.click();
    }

    public void sendRegistrationDetails(String Email, String Password, String ConfirmPassword,String Firstname, String Lastname, String Telephone, Boolean Subscribe){
        registerFirstname.sendKeys(Firstname);
        registerLastname.sendKeys(Lastname);
        registerEmail.sendKeys(Email);
        registerTelephone.sendKeys(Telephone.toString());
        registerPassword.sendKeys(Password);
        registerConfirmPassword.sendKeys(ConfirmPassword);
        if(Subscribe==true){
            registerSubscribeNewsletter.click();
        }


    }

    public void clickOnPrivacyPolicyButton(){
        registerPrivacyPolicyButton.click();
    }
    public void clickOnContinueRegistration(){
        registerSubmitRegistrationDetailsButton.click();
    }

    public Boolean isWarningPromptAvailable(){
        Boolean isWarningAvailable = false;
        try{
            isWarningAvailable = registerPageWarningMessage.isDisplayed();
        }
        catch(Throwable t){

        }
        try{
            isWarningAvailable = registerFieldWarningMessage.isDisplayed();
        }
        catch(Throwable t){

        }

        return isWarningAvailable;
    }
    public String getUniqueEmailAddress(){
        Date date = new Date();
        return "jatingupta" + date.toString().replace(" ", "_"). replace(":", "_") + "@gmail.com";
    }
}
