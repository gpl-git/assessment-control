package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegEmailDanilAntMyStepdefs {
    @Given("I navigate to the {string} page Assessment Control")
    public void iNavigateToThePageAssessmentControl(String url) {
        if(url.equalsIgnoreCase("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
            getDriver().findElement(By.xpath("//span[normalize-space()='Register Now']")).click();
        } else if(url.equalsIgnoreCase("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This automation test set is for Registration Form");
        }
    }

    @Then("I observe the registration page within {int} sec.")
    public void iObserveTheRegistrationPageWithinSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @Then("I fill out the registration form: FN as {string}, LN as {string}, Group Code as {string}, Password {string}, Confirm Password {string}")
    public void iFillOutTheRegistrationFormFNAsLNAsGroupCodeAsPasswordConfirmPassword(String fn, String ln, String gc, String pw, String cpw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fn);
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(ln);
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gc);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pw);
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(cpw);
    }

    @When("I click on Register Button")
    public void iClickOnRegisterButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I should see the message {string} for the Email field")
    public void iShouldSeeTheMessageForTheEmailField(String req) {
        String actualField = getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        assertThat(actualField).isEqualToIgnoringCase(req);

    }


    @When("I fill the Email Field as {string}")
    public void iFillTheEmailFieldAs(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
            }


    @Then("I have been successfully registered")
    public void iHaveBeenSuccessfullyRegistered() {
        assertThat(getDriver().findElement(By.xpath("//body[contains(.,'Registered')]")).isDisplayed()).isTrue();
    }

    @Then("I go to the previous Registration Page")
    public void iGoToThePreviousRegistrationPage() {
        getDriver().navigate().back();
    }

    @When("I fill the Email Field as {string} using other special characters")
    public void iFillTheEmailFieldAsUsingOtherSpecialCharacters(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);

    }


}