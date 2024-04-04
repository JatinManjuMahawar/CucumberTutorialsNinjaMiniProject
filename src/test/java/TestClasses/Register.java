package TestClasses;

import TestPages.RegisterPage;
import Base.Base;
import TestPages.RegisterSuccessPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class Register {

    WebDriver driver = Base.getDriver();
    WebDriver wait;

    RegisterPage registerPage = new RegisterPage(driver);
    RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);

    @Given("User navigate to registration page")
    public void user_navigate_to_registrarion_page() {
        registerPage.clickOnMyAccountDropdown();
        registerPage.clickOnRegisterOption();
    }

    @When("User enters below account details")
    public void user_enters_below_account_details(DataTable dt) {
        Map<String, String> map = dt.asMap(String.class, String.class);
        registerPage.sendRegistrationDetails(registerPage.getUniqueEmailAddress(), map.get("Password"), map.get("ConfirmPassword"), map.get("Firstname"), map.get("Lastname"), map.get("Telephone"), true);
    }

    @When("User select Privacy Policy feild")
    public void user_select_privacy_policy_feild() {
        registerPage.clickOnPrivacyPolicyButton();
    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        registerPage.clickOnContinueRegistration();
    }

    @Then("user logs in")
    public void user_logs_in() {
        Boolean isRegistrationSuccessfull = registerSuccessPage.VerifySuccessfulRegistration();
        Assert.assertEquals(isRegistrationSuccessfull, true);
    }

    @When("User does not enter anything")
    public void user_does_not_enter_anything() {
        registerPage.sendRegistrationDetails("", "", "", "", "", "", true);
    }

    @Then("User gets warning message and registration fails")
    public void user_gets_warning_message_and_registration_fails() {
        Boolean isWarningAvailable = registerPage.isWarningPromptAvailable();
        Assert.assertEquals(isWarningAvailable, true);
    }

}
