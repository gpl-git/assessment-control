package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class PasswordCPStepdefs {
    @Given("I open {string} Page.")
    public void iOpenPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("I type {string} into First Name")
    public void iTypeIntoFirstName(String first_name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys(first_name);
    }

    @And("I type {string} into Last Name")
    public void iTypeIntoLastName(String last_name) {
        getDriver().findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys(last_name);
    }

    @When("I type {string} into Email")
    public void iTypeIntoEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
    }

    @And("I type {string} into Group Code")
    public void iTypeIntoGroupCode(String Code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"group\"]")).sendKeys(Code);
    }

    @When("I type {string} into Password")
    public void iTypeIntoPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @And("I type {string} into Confirm Password")
    public void iTypeIntoConfirmPassword(String confirm_pw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"confirmPassword\"]")).sendKeys(confirm_pw);
    }

    @Then("{string} confirmation message show be displayed")
    public void confirmationMessageShowBeDisplayed(String confirmation) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed();
    }

    @Then("error message {string} should be displayed.")
    public void errorMessageShouldBeDisplayed(String required) {
        getDriver().findElement(By.xpath("//*[@role=\"alert\"] [contains(text(),'required')]")).isDisplayed();
    }

    @Then("error message {string} should be display too.")
    public void errorMessageShouldBeDisplayToo(String misMatch) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'match')]")).isDisplayed();
    }

    @Then("error message {string} should be display")
    public void errorMessageShouldBeDisplay(String errorM) {
        getDriver().findElement(By.xpath("//*[@role=\"alert\"] [contains(text(),'least')]")).isDisplayed();
    }

    @Then("error message {string} should be display. sj")
    public void errorMessageShouldBeDisplaySj(String expectError) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualError.equals(expectError)).isTrue();
    }

    @Then("I verified the password is masked")
    public void iVerifiedThePasswordIsMasked() {
        String typeValue = getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type");
        assertThat(typeValue.equals("password")).isTrue();
    }
}