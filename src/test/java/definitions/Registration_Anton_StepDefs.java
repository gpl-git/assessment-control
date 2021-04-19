package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Registration_Anton_StepDefs {


    @When("I type {string} into First Name filed")
    public void iTypeIntoFirstNameFiled(String First) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(First);
    }

    @Then("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String Last) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(Last);
    }


    @Then("I type new email into email field")
    public void iTypeNewEmailIntoEmailField() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String newEmail = "test"+randomInt+"@abc.com";
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
    }

    @Then("I type {string} into Group Code filed")
    public void iTypeIntoGroupCodeFiled(String Group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(Group);
    }

    @Then("I type {string} into password filed")
    public void iTypeIntoPasswordFiled(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I type {string} into Confirm Password filed")
    public void iTypeIntoConfirmPasswordFiled(String Cpassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(Cpassword);
    }

    @Then("error message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();
    }

    @Then("Message {string} should be displayed")
    public void MessageShouldBeDisplayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualMessage).isEqualTo(message);
    }
}





