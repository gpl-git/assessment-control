package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LiliyaRegistrationEmailStepdefs {
    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into Group Code field")
    public void iTypeIntoGroupCodeField(String code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(code);
    }

    @And("I type {string} into the Confirm  password field")
    public void iTypeIntoTheConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I input {string} into email field")
    public void iInputIntoEmailField(String arg) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        String newEmail = "username"+ randomInt +"@gmail.com";
        System.out.println(newEmail);
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
    }

    @Then("mat-card with {string} displayed")
    public void matCardWithDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//h4")).isDisplayed()).isTrue();
    }

    @And("I leave email field empty")
    public void iLeaveEmailFieldEmpty() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("");

    }

    @Then("mat-error {string} displayed")
    public void matErrorDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed()).isTrue();
    }

    @When("I click on Group field")
    public void iClickOnGroupField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).click();
    }

    @Then("error message {string} displayed")
    public void errorMessageDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-0']")).isDisplayed()).isTrue();
    }

    @And("I type email with white space {string} into email field")
    public void iTypeEmailWithWhiteSpaceIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I print {string} into email field")
    public void iPrintIntoEmailField(String newEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
    }
}
