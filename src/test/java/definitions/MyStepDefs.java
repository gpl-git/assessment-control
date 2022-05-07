package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MyStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");

    }
}

    @When("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
    }


    @Then("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into emailReg field")
    public void iTypeIntoEmailRegField(String emailReg) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(emailReg);
    }


    @Then("I type {string} into groupCode field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }


    @When("I type {string} into passwordReg field")
    public void iTypeIntoPasswordRegField(String passwordReg ) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(passwordReg);
    }


    @And("I type {string} into confirmPasswordReg field")
    public void iTypeIntoConfirmPasswordRegField(String confirmPasswordReg ) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPasswordReg);
    }


    @Then("I click registration button")
    public void iClickRegistrationButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String registration) {

    }
}
