package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class Teacher_accStepDefs {
    @When("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String fName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fName);
    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String lName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lName);
    }

    @And("I type {string} into Group Code field")
    public void iTypeIntoGroupCodeField(String gCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gCode);
    }

    @And("I type {string} into Confirm password field")
    public void iTypeIntoConfirmPasswordField(String confPwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPwd);
    }

    @When("I click on {string} tab option")
    public void iClickOnTabOption(String tab) {
            getDriver().findElement(By.xpath("//h5[contains(text(),'"+tab+"']")).click();
    }
}



