package definitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class EmailStepDefs {
    @When("I type in new email field")
    public void iTypeInNewEmailField() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys("test" + randomInt + "@abc.com");
    }


    @When("I type abc123@gmail.com into email field")
    public void iTypeEmailIntoEmailField() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys();

    }


    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedError) {
        getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getText();

    }

    @Then("I click on Register Me button")
    public void iClickOnButtonButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]"));
    }

//   @Then("I click on {string} button")
//    public void iClickOnButton(String button) {
//       getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
//  }


    @Then("error message {string} message should be displayed")
    public void errorMessageMessageShouldBeDisplayed(String expectedError) {
        getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).getText();

    }

//    @Then("{string} message should not be displayed")
//    public void messageShouldNotBeDisplayed(String errorMessage) {
//        getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted']")).getText();
//    }

    @Then("{string} page should appear")
    public void pageShouldAppear(String regMessage) {
        getDriver().findElement(By.xpath("//*[contains(text(),'You have been Registered.')]"));
    }
    }







