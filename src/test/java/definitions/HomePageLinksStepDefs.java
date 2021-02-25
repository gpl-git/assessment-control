package definitions;

import cucumber.api.java.en.Then;

import static support.TestContext.getDriver;

public class HomePageLinksStepDefs {
    @Then("I go to back on Home page")
    public void iGoToBackOnHomePage() {
        getDriver().navigate().back();
    }
}
