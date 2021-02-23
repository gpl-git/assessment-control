package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginLarisaStepDefs {
    @Given("I go to {string}")
    public void iGoTo(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I enter {string} into email field")
    public void iEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @And("I enter {string} into password field")
    public void iEnterIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I verify that user is logged in at {string} page")
    public void iVerifyThatUserIsLoggedInAtPage(String expUrl) {
        String curUrl = getDriver().getCurrentUrl();
        assertThat(curUrl.contains(expUrl)).isTrue();

    }

    @And("I verify that {string} user role is displayed")
    public void iVerifyThatUserRoleIsDisplayed(String expRole) {
        String info = getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        assertThat(info.contains(expRole)).isTrue();
    }

    @Then("I go to the page {string}")
    public void iGoToThePage(String page) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+page+"')]")).click();
    }

    @Then("I go to back on Home page")
    public void iGoToBackOnHomePage() {
        getDriver().navigate().back();
    }

}