package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SnehalRegEmailStepDefs {
    @Then("I type {string} in the Email field")
    public void iTypeInTheFieldWithXpath(String Email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Email);
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I clear the field with xpath {string}")
    public void iClearTheFieldWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).clear();
    }

    @And("I verify that {string} is displayed on the mat-form")
    public void iVerifyThatIsDisplayedOnTheMatForm(String emailError) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../..//mat-error[contains(text(),'"+emailError+"')]")).isDisplayed()).isTrue();
    }

    @And("I verify that the user has been registered")
    public void iVerifyThatTheUserHasBeenRegistered() {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).isDisplayed()).isTrue();
    }

    @Then("I type {string} in the First Name field")
    public void iTypeInTheFirstNameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }

    @Then("I type {string} in the Last Name field")
    public void iTypeInTheLastNameField(String lname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lname);
    }

    @Then("I type {string} in the Group Code field")
    public void iTypeInTheGroupCodeField(String gcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gcode);
    }

    @Then("I type {string} in the Password field")
    public void iTypeInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I type {string} in the Confirm Password field")
    public void iTypeInTheConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @When("I type new email")
    public void iTypeNewEmail() {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100);
            String newEmail = "test"+randomInt+"@test.com";
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
        System.out.println(newEmail);
        }

    @When("I type an email with {int} characters in the prefix")
    public void iTypeAnEmailWithCharactersInThePrefix(int number) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
        String newEmail = generatedString+"@test.com";
        //System.out.println(newEmail);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(newEmail);
    }

    @When("I type an email with {int} characters in the domain")
    public void iTypeAnEmailWithCharactersInTheDomain(int number) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number,useLetters,useLetters);
        String newEmail = "test@"+generatedString+".com";
        //System.out.println(newEmail);
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(newEmail);
    }
}
