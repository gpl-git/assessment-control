package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class FirstName_AksanaStepDefs {

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstname);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastname);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupcode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }
}

