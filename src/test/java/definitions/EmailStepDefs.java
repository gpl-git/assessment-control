package definitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static support.TestContext.getDriver;

public class EmailStepDefs {
    @When("I type in new email field")
    public void iTypeInNewEmailField() {
        Random randomGenerator = new Random();
        int randomInt  =  randomGenerator.nextInt(100);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys("test"+randomInt+"@abc.com");
    }


    @When("I type abc into email field")
    public void iTypeEmailIntoEmailField() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys();

    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedError) {
       getDriver().findElement(By.xpath("//*[@id='mat-error-5']")).getText();

    }


    @Then("I click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();

    }


    @Then("error message {string} message should be displayed")
    public void errorMessageMessageShouldBeDisplayed(String expectedError) {
        getDriver().findElement(By.id("mat-error-24")).getText();

    }

    @Then("{string} message should not be displayed")
    public void messageShouldNotBeDisplayed(String errorMessage) {
        getDriver().findElement(By.xpath("//*[@id='mat-error-5']")).getText();
    }

    @When("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String FirstName) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).click();
    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String LastName){
        getDriver().findElement(By.xpath("//input[@id='mat-input-3']")).click();
    }

    @And("I type {string} into Group Code field")
    public void iTypeIntoGroupcodeField(String Group_Code) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-5']")).click();
    }


}



