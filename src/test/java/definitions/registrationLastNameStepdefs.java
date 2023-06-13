package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class registrationLastNameStepdefs {

    @Given("KB I navigate to {string} page")
    public void kbINavigateToPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }

    @When("KB I type {string} into first name field")
    public void kbITypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("KB I type {string} into last name field")
    public void kbITypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("KB I type {string} into email field")
    public void kbITypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("KB I type {string} into group code field")
    public void kbITypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("KB I type {string} into password field")
    public void kbITypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("KB I type {string} into confirm password field")
    public void kbITypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }

    @Then("KB I click {string} button")
    public void kbIClickButton(String registerButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @And("KB I wait for {int} sec")
    public void kbIWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000L *sec);
    }
}
