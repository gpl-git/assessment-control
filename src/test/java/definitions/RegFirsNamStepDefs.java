package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class RegFirsNamStepDefs {

    Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        public String newEmail = "test" +randomInt+ "@test.com";

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }



    @When("I complete registration form")
    public void iCompleteRegistrationForm() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Wick");
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("johnwick007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("johnwick007");
    }

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @Then("I verify that message {string} is displayed")
    public void iVerifyThatMessageIsDisplayed(String expText) {
        String info = getDriver().findElement(By.xpath("//*[@class='mat-card']")).getText();
        assertThat(info.contains(expText)).isTrue();
    }

    @And("I push {string} button")
    public void iPushButton(String arg0) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }


    @When("I type {string} in first name field")
    public void iTypeInFirstNameField(String name) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(name);
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String text) {
        String info = getDriver().findElement(By.xpath("//*[@role='alert'][contains(text(),'"+text+"')]/../..")).getText();
        assertThat(info.contains(text)).isTrue();
        
    }

    @And("I fill out the rest of the fields")
    public void iFillOutTheRestOfTheFields() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Wick");
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("johnwick007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("johnwick007");

    }


    @When("I type Max allowable char in First Name field")
    public void iTypeMaxAllowableCharInFirstNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("q"+ RandomStringUtils.randomAlphabetic(253));

    }

    @When("I type Max+One allowable char in First Name field")
    public void iTypeMaxOneAllowableCharInFirstNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("q"+ RandomStringUtils.randomAlphabetic(254));
    }

    @Then("I verify that error message {string} will be displayed")
    public void iVerifyThatErrorMessageWillBeDisplayed(String error) {
        String info = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden'][contains(text(),'Data too long')]")).getText();
        assertThat(info.contains(error)).isTrue();
    }

    @When("I fill out registration form except First Name Field")
    public void iFillOutRegistrationFormExceptFirstNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Wick");
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(newEmail);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("johnwick007");
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("johnwick007");
    }
}
