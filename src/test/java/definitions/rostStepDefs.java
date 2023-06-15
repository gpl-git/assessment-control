package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class rostStepDefs {
    @Given("I go to {string} page!")
    public void iGoToPage(String url) {
        if (url.equalsIgnoreCase("login")){
            getDriver().get("http://ask-qa.portnov.com/");
        }
        else if (url.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }
        else {
            System.out.println("This site " + url + " is not supported.");
        }


    }


    @When("I type {string} into element with xpath {string}!")
    public void iTypeIntoElementWithXpath(String value, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(value);
    }

    @And("I click on element with xpath {string}!")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }


    @And("I wait for {int} sec!")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I navigate to {string}!")
    public void iNavigateTo(String url) {
        getDriver().get(url);
    }

    @Then("element with xpath {string} should be displayed!")
    public void elementWithXpathShouldBeDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }
}
