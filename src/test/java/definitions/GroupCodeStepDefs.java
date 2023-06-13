package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GroupCodeStepDefs {
    @When("I type {string} into first name field  DD")
    public void iTypeIntoFirstNameFieldDD(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @When("I type {string} into last name field  DD")
    public void iTypeIntoLastNameFieldDD(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into confirm password field DD")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I type {string} into group code field DD")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @Then("confirmation message {string} should be displayed DD")
    public void confirmationMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }

    @Then("error message {string} should be displayed DD")
    public void errorMessageShouldBeDisplayedDD(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }
}
