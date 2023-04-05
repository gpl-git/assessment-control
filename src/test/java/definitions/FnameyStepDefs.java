package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;


import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;



public class FnameyStepDefs {
    @Given("I navigate  to {string} page")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println(url + " is not supported");
        }
    }


    @When("I type {string} into fname field")
    public void iTypeIntoFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);

    }

    @When("I type {string} into the fname field")
    public void iTypeIntoTheFnameField(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }


    @And("I type {string} into last Name field")
    public void iTypeIntoLastNameField(String lName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lName);
    }

    @And("I type {string}into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String gCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gCode);
    }

    @And("I type{string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type{string}into Confirm password field")
    public void iTypeIntoConfirmPasswordField(String cPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(cPassword);
    }


    @Then("{string} Confirmation message should be display")
    public void confirmationMessageShouldBeDisplay(String message) {
        String messageText = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(message.equals(messageText)).isTrue();
    }

    @When("I click {string}button")
    public void iClickButton(String registerMe) {
        getDriver().findElement(By.xpath("//span[text()='Register Me']")).click();
    }


    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();
    }

    @Then("{string} error message shouls be dispalyed")
    public void errorMessageShoulsBeDispalyed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();
    }

    @When("I type {int} alphanumaric charater into fname field")
    public void iTypeAlphanumaricCharaterIntoFnameField(int num) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
//        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(generatedString);
    }

    @When("I type {int} character into fname field")
    public void iTypeCharacterIntoFnameField(int num) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
//        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(generatedString);

    }


    @Then("Error message one{string}should be displayed")
    public void errorMessageOneShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();

    }
}

