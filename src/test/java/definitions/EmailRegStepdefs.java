package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class EmailRegStepdefs {
    @When("I type {string} in the first name field")
    public void iTypeInTheFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'firstName']")).sendKeys(firstName);
    }

    @When("I type {string} in the last name field")
    public void iTypeInTheLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'lastName']")).sendKeys(lastName);
    }

    @When("I type {string} into the email field")
    public void iTypeIntoTheEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'email']")).sendKeys(email);
    }

    @When("I type {string} in the group code field")
    public void iTypeInTheGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'group']")).sendKeys(groupCode);
    }

    @When("I type {string} into the password field")
    public void iTypeIntoThePasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'password']")).sendKeys(password);
    }

    @When("I type {string} into the confirm password field")
    public void iTypeIntoTheConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'confirmPassword']")).sendKeys(confirmPassword);
    }

    @When("click on the {string} button")
    public void clickOnTheButton(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
    }

    @Then("I verify that a {string} message is displayed")
    public void iVerifyThatAMessageIsDisplayed(String message) {
        String confirmation = getDriver().findElement(By.xpath("//h4")).getText();
//        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]")).isDisplayed()).isTrue();
        assertThat(confirmation.equals(message)).isTrue();
    }

    @Then("I verify that a {string} error message is displayed")
    public void iVerifyThatAErrorMessageIsDisplayed(String errorMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//*[@id='mat-error-2']")).getText();
        assertThat(actualMessage.equals(errorMessage)).isTrue();
    }
}
