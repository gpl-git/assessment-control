package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class FirstNameStepDefs {
    @When("I type {string} into first name field  DD")
    public void iTypeIntoFirstNameFieldDD(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @When("I type {string} into last name field  DD")
    public void iTypeIntoLastNameFieldDD(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into confirm password field DD")
    public void iTypeIntoConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath(""))
    }
}
