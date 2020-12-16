package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class RegistrationElenaStepdefs {
    @When("I enter {string} as first name")
    public void iEnterAsFirstName(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I enter {string} as last name")
    public void iEnterAsLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);



    }

    @When("I enter {string} as group code")
    public void iEnterAsGroupCode(String code) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(code);
    }

    @And("I confirm password as {string}")
    public void iConfirmPasswordAs(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);

    }

    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String message) {
        String actMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actMessage.equals(message)).isTrue();
    }


    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String error) {
        String actError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actError.equals(error)).isTrue();

    }
}
