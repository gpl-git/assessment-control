package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import support.TestContext;

public class AnilStepDefs {
    @Given("I open the url {string}")
    public void iOpenTheUrl(String url) {
        TestContext.getDriver().get(url);
    }

    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String text) {
        Assertions.assertThat(TestContext.getDriver().getTitle()).isEqualToIgnoringCase(text);
    }

    @When("I type {string} into the element with xpath {string}")
    public void iTypeIntoTheElementWithXpath(String text, String xpath) {
        TestContext.getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Then("I should see the message that {string} into the element with xpath {string}")
    public void iShouldSeeTheMessageThatIntoTheElementWithXpath(String msg, String xpath) {
        Assertions.assertThat(TestContext.getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
        Assertions.assertThat(msg.equalsIgnoreCase(TestContext.getDriver().findElement(By.xpath(xpath)).getText()));
    }

    @When("I click on the element with xpath {string}")
    public void iClickOnTheElementWithXpath(String xpath) {
        TestContext.getDriver().findElement(By.xpath(xpath)).click();
    }

    @And("I wait {int} sec")
    public void iWaitSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I clear the element with xpath {string}")
    public void iClearTheElementWithXpath(String xpath) {
        TestContext.getDriver().findElement(By.xpath(xpath)).clear();
    }
}
