package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationLastNameStepDefs {
    @Given("I navigate to registration page")
    public void iNavigateToRegistrationPage() {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("I type first name {string}")
    public void iTypeFirstName(String fName) {
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fName);

    }

    @And("I type last name {string}")
    public void iTypeLastName(String lName) {
        getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lName);

    }

    @And("I type email {string}")
    public void iTypeEmail(String eMail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(eMail);

    }

    @And("I type group code {string}")
    public void iTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(groupCode);

    }

    @And("I type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);


    }

    @And("I type confirm password {string}")
    public void iTypeConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmPassword);


    }

    @And("I click Register Me")
    public void iClickRegisterMe() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();


    }

    @Then("message {string} appears")
    public void messageAppears(String message) throws InterruptedException {
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]")).isDisplayed()).isTrue();
    }
}
