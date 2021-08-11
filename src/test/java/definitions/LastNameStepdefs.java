package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LastNameStepdefs {
    @When("I type {string} in first name field")
    public void iTypeInFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'firstName']")).sendKeys(firstName);
    }

    @When("I type {string} in last name field")
    public void iTypeInLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'lastName']")).sendKeys(lastName);
    }

    @When("I type {string} in group code field")
    public void iTypeInGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'group']")).sendKeys(groupCode);
    }

    @When("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname = 'confirmPassword']")).sendKeys(confirmPassword);

    }

    @Then("I verify that I revive a {string} message")
    public void iVerifyThatIReviveAMessage(String message) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).isDisplayed()).isTrue();
    }


}
