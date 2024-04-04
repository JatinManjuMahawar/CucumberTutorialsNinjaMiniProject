package TestClasses;

import io.cucumber.java.en.*;
public class Search {

    @Given("User navigates to search")
    public void user_navigates_to_search() {
        System.out.println("Logintonavigation");
    }

    @When("User enters product name in searchbar")
    public void user_enters_product_name_in_searchbar() {
        System.out.println("Yo");
    }

    @When("User presses search button")
    public void user_presses_search_button() {
        System.out.println("Yo");
    }

    @Then("User is able to see the product")
    public void user_is_able_to_see_the_product() {
        System.out.println("Yo");
    }

    @Then("User should not be able to see the product")
    public void user_should_not_be_able_to_see_the_product() {
        System.out.println("Yo");
    }

    @When("User enters nothing in searchbar")
    public void user_enters_nothing_in_searchbar() {
        System.out.println("Yo");
    }

    @Then("User should stay on the same page")
    public void user_should_stay_on_the_same_page() {
        System.out.println("Yo");
    }

}
