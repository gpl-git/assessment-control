package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static support.TestContext.getDriver;

public class FirstName_AksanaStepDefs {

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstname);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastname);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupcode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String message) {
        assertThat(getDriver().findElement(By.xpath("//h4")).isDisplayed()).isTrue();

    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errormessage) {
        getDriver().findElement(By.xpath("//*[contains (text() , '"+errormessage+"')]")).isDisplayed();
    }

    @When("I enter {int} characters into first name field")
    public void iEnterCharactersIntoFirstNameField(int number) {
        int length = number;
        boolean useLetters = true;
        boolean useNumbers = true;
        String newString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(newString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(newString);
    }

    @Then("warning message {string} should be displayed")
    public void warningMessageShouldBeDisplayed(String message) {
        getDriver().findElement(By.xpath("//div[contains (text(),  'Data too long for column')]")).isDisplayed();
    }
}

