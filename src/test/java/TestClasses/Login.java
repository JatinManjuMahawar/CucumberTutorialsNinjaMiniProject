package TestClasses;

import Base.Base;
import MyHooks.Hooks;
import TestPages.LoginPage;
import TestPages.LoginSuccessPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class Login {

    WebDriver driver = Base.getDriver();
    WebDriver wait;
    LoginPage loginObj = new LoginPage(driver);
    LoginSuccessPage loginSuccessObj = new LoginSuccessPage(driver);


    @Given("^User open the application URL$")
    public void User_open_the_application_URL(){
        System.out.println("User navigated to Login Page");
    }

    @And("^User enters valid (.+) address$")
    public void userEntersValidEmailAdd(String email) {
        loginObj.sendEmailAdd(email);
    }

    @When("^User navigates to Login Page$")
    public void userNavigatesToLoginPage() throws Exception {
        loginObj.clickOnMyAccountDropdown();
        loginObj.cliclOnLoginOption();
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        Boolean isLoginSuccess = loginSuccessObj.VerifySuccessfulLogin();
        Assert.assertEquals(isLoginSuccess, true);
    }

    @And("^User enters invalid Email address (.+)$")
    public void userEntersInvalidEmailAddress(String invalidEmail) {
        loginObj.sendEmailAdd(loginObj.getUniqueEmailAddress());
    }

    @And("^User enters invalid passwords (.+)$")
    public void userEntersInvalidPasswords(String invalidPassword) {
        loginObj.sendPassword(invalidPassword);
    }

    @Then("^User should not login successfully$")
    public void userShouldNotLoginSuccessfully() {
        Boolean isLoginFailed = loginObj.VerifyFailedLogin();

        Assert.assertEquals(isLoginFailed, true);
    }

    @But("^User should get a proper warning message$")
    public void userShouldGetAProperWarningMessage() {
        Boolean isLoginFailed = loginObj.VerifyFailedLogin();

        Assert.assertEquals(isLoginFailed, true);
    }

    @And("^User enters valid passwords (.+)$")
    public void userEntersValidPasswords(String validPassword) {
        loginObj.sendPassword(validPassword);
    }

    @And("^User enters no Email address (.+)$")
    public void userEntersNoEmailAddress(String noEmail) {
        loginObj.sendEmailAdd(" ");
    }

    @And("^User enters no passwords (.+)$")
    public void userEntersNoPasswords(String noPassword) {
        loginObj.sendPassword(" ");
    }

}