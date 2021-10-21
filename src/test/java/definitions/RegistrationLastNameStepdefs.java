package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationLastNameStepdefs {
    @Given("I navigate to the registration page")
    public void iNavigateToTheRegistrationPage() {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @Then("I fill out input field {string} with {string}")
    public void iFillOutFieldWith(String fieldName, String text) {
        if(fieldName.equalsIgnoreCase("First Name")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(text);
        }
        else if (fieldName.equalsIgnoreCase("Last Name")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(text);
        }
        else if (fieldName.equalsIgnoreCase("Email")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(text);
        }
        else if (fieldName.equalsIgnoreCase("Group Code")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(text);
        }
        else if (fieldName.equalsIgnoreCase("Password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(text);
        }
        else if (fieldName.equalsIgnoreCase("Confirm Password")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(text);
        }
    }

    @And("I push {string} button")
    public void iPushButton(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+buttonName+"')]")).click();
    }

    @And("I am waiting for {int} sec")
    public void iAmWaitingForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @Then("message {string} should be displayed on the page.")
    public void messageShouldBeDisplayedOnThePage(String confMessage) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),'"+confMessage+"')]")).getText()).isEqualToIgnoringCase(confMessage);
    }

    @Then("alert message {string} should be displayed under input field {string}")
    public void alertMessageShouldBeDisplayedUnderInputField(String alertMessage, String inputField) {
        if(inputField.equalsIgnoreCase("Last Name") && alertMessage.equalsIgnoreCase("This field is required")){
            assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']/../../..//mat-error[text()='"+alertMessage+"']")).getText()).isEqualToIgnoringCase(alertMessage);
        }
        else if(inputField.equalsIgnoreCase("Last Name") && alertMessage.equalsIgnoreCase("No more than 254 characters allowed")){
            assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']/../../..//mat-error[text()='"+alertMessage+"']")).getText()).isEqualToIgnoringCase(alertMessage);
        }
    }
}
