package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.AbstractStringAssert;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegLanaStepdefs {
    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }


    @When("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @When("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into Confirm password field")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @Then("I see message {string}")
    public void iSeeMessage(String message) {
        String expectedMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(expectedMessage).isEqualTo(message);
    }

    @Then("I see error message {string}")
    public void iSeeErrorMessage(String ermessage) {
       String expectedErMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
       assertThat(expectedErMessage).isEqualTo(ermessage);
    }
}
