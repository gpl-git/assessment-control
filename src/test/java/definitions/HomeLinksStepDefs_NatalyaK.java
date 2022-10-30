package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class HomeLinksStepDefs_NatalyaK {
    @When("I click on {string} link")
    public void iClickOnLink(String linkName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + linkName + "')]")).click();
    }

    @Then("page with header {string} should open")
    public void pageWithHeaderShouldOpen(String pageHeader) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'" + pageHeader + "')]")).isDisplayed()).isTrue();
    }

    @When("I click on the {string} button on the menu")
    public void iClickOnTheButtonOnTheMenu(String menuButtonText) {
        getDriver().findElement(By.xpath("//h5[text()='" + menuButtonText + "']")).click();
    }

    @Then("I should land on page with url {string}")
    public void iShouldLandOnPageWithUrl(String expectedURL) {
        String actualURL = getDriver().getCurrentUrl();
        assertThat(expectedURL.equals(actualURL)).isTrue();
    }

    @Then("pop-up with {string} name should be displayed")
    public void popUpWithNameShouldBeDisplayed(String popupName) {
        assertThat(getDriver().findElement(By.xpath("//h1[text()='" + popupName + "']")).isDisplayed()).isTrue();
    }

    @Then("pop-up with {string} name should not be displayed")
    public void popUpWithNameShouldNotBeDisplayed(String popupName) {
        assertThat(getDriver().findElement(By.xpath("//h1[text()='" + popupName + "']")).isDisplayed()).isFalse();
    }

    @When("I type {string} for student user")
    public void iTypeForStudentUser(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }
}
