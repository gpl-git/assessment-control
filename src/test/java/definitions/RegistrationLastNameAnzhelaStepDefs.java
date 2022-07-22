package definitions;

import cucumber.api.java.en.Then;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class RegistrationLastNameAnzhelaStepDefs {
    @Then("I A type {string} into lastName field")
    public void iATypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("A error message {string} is displayed")
    public void aErrorMessageIsDisplayed(String errorMessage) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(), '"+errorMessage+"')]")).isDisplayed();
    }

    @When("I A enter {string} into First Name field")
    public void iAEnterIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I A enter {string} into Email field")
    public void iAEnterIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I A enter {string} into Group Code")
    public void iAEnterIntoGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @When("I A type {string} in the Password field")
    public void iATypeInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I A click on the Confirm Password field")
    public void iAClickOnTheConfirmPasswordField() {

    }

    @And("I A type {string} in the Confirm Password field")
    public void iATypeInTheConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @And("I A see verification message {string}")
    public void iASeeVerificationMessage(String verificMessage) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']//../h4")).isDisplayed();
//        assertThat(getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).getText().equals("You have been Registered."));
    }

    @Then("A error message {string} is not displayed")
    public void aErrorMessageIsNotDisplayed(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//mat-error")).isDisplayed()).isFalse();
    }
}
