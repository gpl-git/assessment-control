package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationFNStepDefs {
    @When("I type {string} into the First Name field")
    public void iTypeIntoTheFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("first name error message should be displayed")
    public void firstNameErrorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']/../../..//mat-error")).isDisplayed());
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


    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confPsw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPsw);
    }


    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String confMsg){
        String res = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(res.contains(confMsg));
    }

    @And("I switch to a new window")
    public void iSwitchToANewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while (iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
        }

    @And("an alert message {string} should be displayed")
    public void anAlertMessageShouldContainText(String alertFN) {
        String actual = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();
        assertThat(actual.contains(alertFN));

    }

    @Then("error {string} should be displayed")
    public void errorShouldBeDisplayed(String errorFN) {
        String actual = getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']/../../..//mat-error")).getText();
        assertThat(actual.equals(errorFN));
    }

    @When("I type Alpha Numeric Characters {int} into the First Name field")
    public void iTypeAlphaNumericCharactersIntoTheFirstNameField(int number) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(generatedString);

    }
}

