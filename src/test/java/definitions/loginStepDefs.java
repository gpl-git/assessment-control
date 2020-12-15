package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;

public class loginStepDefs {
    @Given("I open {string}")
    public void iOpen(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @And("I wair for {int} sec")
    public void iWairForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I type {string} as email")
    public void iTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//input[@ formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} in pw")
    public void iTypeInPw(String pw) {
        getDriver().findElement(By.id("mat-input-1")).sendKeys(pw);
    }

    @When("I click sing in")
    public void iClickSingIn() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I verify that user role is equal to {string}")
    public void iVerifyThatUserRoleIsEqualTo(String userRole) {
        String actualRole = getDriver().findElement(By.xpath("//header")).getText();
        assertThat(actualRole.contains(userRole)).isTrue();
    }
}
