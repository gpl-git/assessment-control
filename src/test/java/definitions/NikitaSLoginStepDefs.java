package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class NikitaSLoginStepDefs {
    @Given("I go to {string} page N.R.")
    public void iGoToPageNR(String page) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I type {string} into email field N.R.")
    public void iTypeIntoEmailFieldNR(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field N.R.")
    public void iTypeIntoPasswordFieldNR(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);
    }

    @When("I click on {string} button N.R.")
    public void iClickOnButtonNR(String btnName) {
        getDriver().findElement(By.xpath("//span[text()='"+btnName+"']")).click();
    }

    @Then("I verify current url as {string} N.R.")
    public void iVerifyCurrentUrlAsNR(String curUrl) {
        String actualUrl = getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(curUrl)).isTrue();
    }
}
