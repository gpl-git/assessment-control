package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class regGroupCodeStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page){
            case "login":{
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            }
            case "registration":{
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            } default:{
                System.out.println("The Site "+page+" is not supported");
            }
        }
    }

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(groupCode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPassword);
    }


    @Then("I verify that element {string} is present")
    public void iVerifyThatElementIsPresent(String regMessage) {
        String message = getDriver().findElement(By.xpath("//h4[text()='You have been Registered.']")).getText();
        assertThat(message.equals(regMessage)).isTrue();
    }

    @Then("I confirm that error message {string} is displayed")
    public void iConfirmThatErrorMessageIsDisplayed(String notification) {
        String errMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(errMessage.equals(notification)).isTrue();
    }
}

