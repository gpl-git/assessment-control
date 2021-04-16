package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegStepDefs {
    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }


    @And("I type {string} into group code")
    public void iTypeIntoGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(groupCode);
    }


    @And("I type {string} into confirmation field")
    public void iTypeIntoConfirmationField(String passConfirm) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(passConfirm);
    }

    @And("I click Register Me button")
    public void iClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Register Me')]")).click();

    }

    @Then("I verify user registration message {string}")
    public void iVerifyUserRegistrationMessage(String message) {
        String actualName = getDriver().findElement(By.xpath("//*[@class='mat-card']")).getText();
        assertThat(actualName).isEqualTo(message);
    }


    @And("I click confirmation field")
    public void iClickConfirmationField() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).click();

    }

}
