package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class FirstNameStepdefs {

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");

    }


    @And("I waiting for {int} sec")
    public void iWaitingForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstN) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstN);
    }


    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastN) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastN);
    }

    @And("I type {string} in email field")
    public void iTypeInEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }


    @And("I type {string} into group field")
    public void iTypeIntoGroupField(String group) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(group);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String Pw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Pw);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confPw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPw);
    }

    @When("I click button {string} button")
    public void iClickButtonButton(String RegMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }


    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String ConfMessDisplayed) {
        String messageText = getDriver().findElement(By.xpath("//h4")).getText();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String firstNameError) {
       String error= getDriver().findElement(By.xpath("//mat-error")).getText();
       assertThat(error.equals(firstNameError));
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String error) {
      assertThat(getDriver().findElement(By.xpath("//simple-snack-bar")).isDisplayed()).isTrue();

    }
}
