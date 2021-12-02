package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SabrinaHomePageLinks {
    @Then("element with xpath {string} should be displayed")
    public void elementWithXpathShouldBeDisplayed(String xpath) {
      assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }

    @When("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("I element with xpath {string} should contain text {string}")
    public void iElementWithXpathShouldContainText(String xpath, String text) {
        String actualText=getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualToIgnoringCase(text);
    }

    @Then("url should be {string}")
    public void urlShouldBe(String url) {
        String actualUrl=getDriver().getCurrentUrl();
        assertThat(actualUrl).isEqualTo(url);
    }
}
