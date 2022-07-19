package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.ObjectAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Registration_FirstName_AylinStepDef {

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);

    }

    @When("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);

    }

    @When("I type {string} into group code field")
    public void iTypeIentoGroupCodeField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);

    }

    @And("I enter {string} as confirm password")
    public void iEnterAsConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

    }

    @Then("registration confirmation page {string} should be displayed")
    public void registrationConfirmationPageShouldBeDisplayed(String Registered) {
    }

    @When("I clear the firstname field")
    public void iClearTheFirstnameField() {
    }

    @Then("alert message should be displayed")
    public void alertMessageShouldBeDisplayed() {
    }

    @Then("alert message should contain text {string}")
    public void alertMessageShouldContainText(String alert) {
    }

    @Then("should contain text {string}")
    public void shouldContainText(String message) {
    }


}





