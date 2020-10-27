package definitions;

import cucumber.api.java.en.Given;

import static support.TestContext.getDriver;

public class RegStepDef {
    @Given("I open {string}")
    public void iOpen(String url) {
        if (url.equals("registrantion"))
            getDriver().get(("ask-qa.portnov.com/#/registration"));

    }else if
}
}