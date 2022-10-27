package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class regGroupCodeDmitrySStepDefs {
    @Given("I need open {string} page")
    public void iNeedOpenPage(String url) {
        if (url.equals("ask-qa")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }
    }

    @Then("I need click on {string} button")
    public void iNeedClickOnButton(String registerNow) {
        if (registerNow.equals("Register Now")){
            getDriver().findElement(By.xpath("//span[contains(text(),'Register Now')]")).click();
        }
    }

    @Then("I need type {string} into {string} field")
    public void iNeedTypeIntoField(String firstName, String firstNameField) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(firstName);
    }

    @And("I also type {string} into {string} field")
    public void iAlsoTypeIntoField(String lastName, String lastNameField) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys(lastName);
    }

    @Then("I input {string} into {string} field")
    public void iInputIntoField(String email, String emailField) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys(email);
    }

    @And("I need input {string} into {string} field")
    public void iNeedInputIntoField(String password, String passwordField) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-6']")).sendKeys(password);
    }

    @And("I also need input {string} into {string} field")
    public void iAlsoNeedInputIntoField(String confirmPassword, String confirmPasswordField) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-7']")).sendKeys(confirmPassword);
    }

    @Given("I will type {string} into {string} input field")
    public void iWillTypeIntoInputField(String groupCode, String groupCodeField) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(groupCode);
        Thread.sleep(1000);
    }

    @And("I push on {string} button")
    public void iPushOnButton(String registerMeBtn) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
        Thread.sleep(1000);
    }

    @And("element with xpath {string} is displayed")
    public void elementWithXpathIsDisplayed(String confirmationMessage) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(confirmationMessage)).isDisplayed();
        //Thread.sleep(1000);
    }

    @Given("I will type {int} alpha character into {string} input field")
    public void iWillTypeAlphaCharacterIntoInputField(int number, String groupCodeField) throws InterruptedException {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(generatedString);
        Thread.sleep(1000);
    }

    @Given("I will type {int} numeric character into {string} input field")
    public void iWillTypeNumericCharacterIntoInputField(int number, String groupCodeField) throws InterruptedException {
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);

        //System.out.println(generatedString);
        getDriver().findElement(By.xpath("//input[@id='mat-input-5']")).sendKeys(generatedString);
        Thread.sleep(1000);
    }

    @And("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) throws InterruptedException {
        String actualError = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-3']")).getText();
        //System.out.println(actualError);
        Thread.sleep(1000);
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
}
