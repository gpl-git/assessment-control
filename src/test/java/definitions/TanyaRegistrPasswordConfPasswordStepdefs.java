package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;


public class TanyaRegistrPasswordConfPasswordStepdefs {

    @When("I type {string} into {string} field in the Registration form")
    public void iTypeInField(String input, String fieldName) {
        if(fieldName.equals("First Name")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(input);
        }else if (fieldName.equals("Last Name")){
            getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(input);
        }else if (fieldName.equals("Email")) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(input);
        }else if (fieldName.equals("Group Code")) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(input);
        }else if (fieldName.equals("Password")) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(input);
        }else if (fieldName.equals("Confirm Password")) {
            getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(input);
        }else{
            System.out.println("Field name should be exact as in the registration form");
        }
    }

    @Then("message @You have been Registered.@ should be the displayed")
    public void messageYouHaveBeenRegisteredShouldBeTheDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/..//*[contains(text(),'You have been Registered.')]")).isDisplayed()).isTrue();
    }

    @And("error message for the Register form should not be present")
    public void errorMessageForTheRegisterFormIsNotDisplayed() {
        assertThat(getDriver().findElements(By.xpath("//mat-error[@class='mat-error ng-star-inserted']"))).hasSize(0);
    }

    @And("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expErrorMessage) {
       String actErrorMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+expErrorMessage+"')]")).getText();
       assertThat(actErrorMessage.equals(expErrorMessage)).isTrue();
    }

    @And("I click on the element with XPath {string}")
    public void iClickOnTheElementWithXPath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }
}
