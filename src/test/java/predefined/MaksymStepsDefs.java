package predefined;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MaksymStepsDefs {
    @Given("I navigate to {string} web site")
    public void iNavigateToWebSite(String page) {
        getDriver().navigate().to(page);
        }

    @Then("I type {string} into search field")
    public void iTypeIntoSearchField(String searchInfo) {
        getDriver().findElement(By.name("q")).sendKeys(searchInfo);
    }

    @Then("I click on find button")
    public void iClickOnFindButton() {
        getDriver().findElement(By.id("search_icon")).click();
    }

    @Then("I wait for {int} seconds")
    public void iWaitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds* 1000L);
    }

    @Then("search result {string} should be present")
    public void searchResultShouldBePresent(String ExpectedSearchRes) {
        String actualSearchRes = getDriver().findElement(By.name("q")).getAttribute("value");
        assertThat(actualSearchRes.equals(ExpectedSearchRes)).isTrue();

    }

    @Then("I navigate to back")
    public void iNavigateToBack() {
        getDriver().navigate().back();
    }

    @Then("I refresh the current page")
    public void iRefreshTheCurrentPage() {
    getDriver().navigate().refresh();
    }


    @Then("I click on Images link")
    public void iClickOnImagesLink() {
        getDriver().findElement(By.id("images")).click();
    }
}
