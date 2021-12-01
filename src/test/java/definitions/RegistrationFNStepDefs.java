package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationFNStepDefs {
    @When("I type {string} into the First Name field")
    public void iTypeIntoTheFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("first name error message should be displayed")
    public void firstNameErrorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-form-field[1]//mat-error[1]")).isDisplayed()).isTrue();
    }

    @And("error message should contain text {string}")
    public void errorMessageShouldContainText(String message) {
        String actualText = getDriver().findElement(By.xpath("//mat-form-field[1]//mat-error[1]")).getText();
        assertThat(actualText.equals(message));
    }

    @When("I clear the First Name field")
    public void iClearTheFirstNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
    }

    @Then("first name error message should not be displayed")
    public void firstNameErrorMessageShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-form-field[1]//mat-error[1]")).isDisplayed()).isFalse();
    }
}
