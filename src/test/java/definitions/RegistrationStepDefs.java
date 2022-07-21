package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationStepDefs {

    @When("I type {string}")
    public void iType(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String Mickey) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(Mickey);
    }

    @Then("I type {string} into the Last Name field")
    public void iTypeIntoTheLastNameField(String Mouse) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(Mouse);

    }

    @Then("I type {string} into groupCode field")
    public void iTypeIntoGroupCodeField(String Jun02) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(Jun02);
    }

    @Then("I enter {string} as Confirm Password")
    public void iEnterAsConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

    }

    @When("I leave email field blank")
    public void iLeaveEmailFieldBlank() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
    }

    @Then("I should see a message {string} in the email field")
    public void iShouldSeeAMessageInTheEmailField(String text) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email'][@aria-required='true']")).sendKeys(text);
    }

    @When("I enter {string}")
    public void iEnter(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I should see a warning message {string} under the email field")
    public void iShouldSeeAWarningMessageUnderTheEmailField(String text) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).isDisplayed()).isTrue();
    }

    @Then("I leave password field blank")
    public void iLeavePasswordFieldBlank() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
    }

    @And("I verify that {string} message is displayed")
    public void iVerifyThatMessageIsDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).isDisplayed()).isTrue();
    }
}

