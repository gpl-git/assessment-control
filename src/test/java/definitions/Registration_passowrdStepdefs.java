package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Registration_passowrdStepdefs {
    @Given("I Navigate to {string} button")
    public void iNavigateToButton(String registration) {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper'][contains(text(),'Register Now')]")).click();


    }

    @When("I type {string} into first name filed")
    public void iTypeIntoFirstNameFiled(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("I click register me button")
    public void iClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Register Me')]")).click();
    }

    @And("{string} message should appear")
    public void messageShouldAppear(String registrationmsg) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(), '"+registrationmsg+"')]")).isDisplayed()).isTrue();
    }

    @When("I type new email")
    public void iTypeNewEmail() {
        Random  randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys("katya"+randomInt+"@gmail.com");
    }

    @And("error {string} should appear")
    public void errorShouldAppear(String expectederrormsg) {
        String actualerror =  getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        assertThat(actualerror.equals(expectederrormsg)).isTrue();



    }
}

