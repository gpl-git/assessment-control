package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class RegPasswordLuciaStepDefs {
    @Given("I navigate to registration page")
    public void iNavigateToRegistrationPage() {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(code);
    }
    @And("I click on register me button")
    public void iClickOnRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[text()='Register Me']")).click();g
    }

    @Then("{string} error text should be displayed")
    public void errorTextShouldBeDisplayed(String text) {
        String error = getDriver().findElement(By.xpath("//div[contains(@class,'ng-tns-c9-6')]/mat-error[text()='This field is required']")).getText();
        System.out.println(error);
        assertThat(error.equals(text));
    }

    @Then("{string} error message should pop up")
    public void errorMessageShouldPopUp(String message) {
        String error = getDriver().findElement(By.xpath("//mat-error[text()='Whitespaces are not allowed']")).getText();
        System.out.println(error);
        assertThat(error.equals(message));
    }

    @When("I clear password field")
    public void iClearPasswordField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).clear();
    }

    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        String error = getDriver().findElement(By.xpath("//mat-error[contains(text(),'5 characters')]")).getText();
        System.out.println(error);
        assertThat(error.equals(message));
    }


    @When("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPass);
    }

    @Then("{string} error text should pop up")
    public void errorTextShouldPopUp(String warning) {
        String error = getDriver().findElement(By.xpath("//mat-error[text()='Entered passwords should match']")).getText();
        System.out.println(error);
        assertThat(error.equals(warning));
    }

    @When("I clear confirm password field")
    public void iClearConfirmPasswordField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).clear();
    }

    @Then("registration confirmation page should be displayed")
    public void registrationConfirmationPageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//h4[text()='You have been Registered.']")).isDisplayed()).isTrue();
    }
}
