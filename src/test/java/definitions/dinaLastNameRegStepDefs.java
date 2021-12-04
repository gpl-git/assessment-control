package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;



public class dinaLastNameRegStepDefs {
    private String actual;

//    @When("I type {string} into First Name field")
//    public void iTypeIntoFirstNameField(String firstName) {
//        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(firstName);
//
//    }


    @When("I type {string} into the Last Name field")
    public void iTypeIntoTheLastNameField(String lastname) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(lastname);
    }

    @When("I input {string} into password field")
    public void iInputIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I input {string} into confirm password field")
    public void iInputIntoConfirmPasswordField(String confirmPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPass);
    }
    @And("I click into {string} button")
    public void iClickIntoButton(String registerMe) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).sendKeys(registerMe);

    }


    @When("I clear the Last Name field")
    public void iClearTheLastNameField() {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
    }

    @Then("I validate Last Name field displays error message {string}")
    public void iValidateLastNameFieldDisplaysErrorMessage(String lastnameMessage) {
        String actual = getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']/../../..//mat-error")).getText();
        System.out.println(actual);
        assertThat(actual.equals(lastnameMessage));
    }

    @When("I type Alpha Numeric Characters {int} into the Last Name field")
    public void iTypeAlphaNumericCharactersIntoTheLastNameField(int number) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(generatedString);
    }
}
