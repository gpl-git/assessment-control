package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class regGroupCodeDmitrySStepDefs {
    @Given("I need open {string} page")
    public void iNeedOpenPage(String url) {
        if (url.equals("ask-qa")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @Then("I need click on {string} button")
    public void iNeedClickOnButton(String button) {

            getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();

    }

    @Then("I need type {string} into First Name field")
    public void iNeedTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I also type {string} into Last Name field")
    public void iAlsoTypeIntoField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("I input {string} into Email field")
    public void iInputIntoField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I need input {string} into Password field")
    public void iNeedInputIntoField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I also need input {string} into Confirm Password field")
    public void iAlsoNeedInputIntoField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Given("I will type {string} into Group Code input field DS")
    public void iWillTypeIntoInputFieldDS(String groupCode) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
        Thread.sleep(1000);
    }

    @And("I push on {string} button DS")
    public void iPushOnButtonDS(String registerMeBtn) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+registerMeBtn+"')]")).click();
        Thread.sleep(1000);
    }

    @Then("success message {string} should be displayed DS")
    public void successMessageShouldBeDisplayedDS(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).getText();
        // System.out.println(actError);
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }

    @Given("I will type {int} alpha character into Group Code input field")
    public void iWillTypeAlphaCharacterIntoInputField(int number) throws InterruptedException {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(generatedString);
        Thread.sleep(1000);
    }

    @Given("I will type {int} numeric character into Group Code input field")
    public void iWillTypeNumericCharacterIntoInputField(int number) throws InterruptedException {
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(generatedString);
        Thread.sleep(1000);
    }

    @And("error message {string} should be displayed DS")
    public void errorMessageShouldBeDisplayedDS(String expectedError) throws InterruptedException {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        //System.out.println(actualError);
        Thread.sleep(1000);
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @And("I wait for {int} sec DS")
    public void iWaitForSecDS(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Given("I will type {int} alphanumeric character into Group Code input field DS")
    public void iWillTypeAlphanumericCharacterIntoGroupCodeInputFieldDS(int number) throws InterruptedException {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(generatedString);
        Thread.sleep(1000);
    }

}
