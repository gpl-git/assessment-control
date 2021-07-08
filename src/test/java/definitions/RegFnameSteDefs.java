package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class RegFnameSteDefs {
    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }


    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lname);
    }

    @And("I type {string} into group field")
    public void iTypeIntoGroupField(String gcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gcode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @Then("I verify that element {string} is present")
    public void iVerifyThatElementIsPresent(String confMessage) {
        String actMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actMessage.equals(confMessage)).isTrue();
    }

    @Then("I verify that error message contains {string}")
    public void iVerifyThatErrorMessageContains(String errorMessage) {
        String message=getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(message.equals(errorMessage)).isTrue();
    }
}
