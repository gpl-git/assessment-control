package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class registrationPasswordDana {
    @Then("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String FirstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(FirstName);
    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String LastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(LastName);
    }

    @And("I type {string} into Email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into Group Code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I type {string} into Password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type {string} into Confirm Password field")
    public void iTypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("I click {string} button")
    public void iClickButton(String btn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();

    }

    @Then("element with xpath {string} should be displayed")
    public void elementWithXpathShouldBeDisplayed(String registrationConfirmation) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'Registered')]")).isDisplayed()).isTrue();

    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+errorMessage+"')]")).isDisplayed()).isTrue();

    }
}


