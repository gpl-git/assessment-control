package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class SettKomalStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        getDriver().get(url);

    }


    @Then("I type {string} in email field")
    public void iTypeInEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} as password")
    public void iTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @And("I click {string} bttn")
    public void iClickBttn(String signIn) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I click on {string}")
    public void iClickOn(String settings) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }


    @Then("element with {string} should be displayed")
    public void elementWithShouldBeDisplayed(String settings) {
        getDriver().findElement(By.xpath("//h4")).isDisplayed();
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String changeYourName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Name')]")).click();
    }

    @Then("I clear the element with {string} New name")
    public void iClearTheElementWithNewName(String xpath) {
        getDriver().findElement(By.xpath("//input[@placeholder='New name']")).clear();
    }

    @Then("I type {string} in the New name field")
    public void iTypeInTheNewNameField(String newName) {
        getDriver().findElement(By.xpath("//input[@placeholder='New name']")).sendKeys(newName);
    }

    @Then("I click on {string} buttn")
    public void iClickOnButtn(String Change) {
        getDriver().findElement(By.xpath("//span[text()='Change']")).click();
    }

    @And("I verify the name change")
    public void iVerifyTheNameChange() {
        getDriver().findElement(By.xpath("//p[contains(text(),'TEACHER')]")).isDisplayed();
    }

    @And("I verify the name name for student")
    public void iVerifyTheNameNameForStudent() {
        getDriver().findElement(By.xpath("//p[contains(text(),'STUDENT')]")).isDisplayed();
    }

}
