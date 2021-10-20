package definitions;

import cucumber.api.java.en.Given;

public class PredefinedStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")){
            getDriver()
        }
    }
}
