package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
        if (page.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else if (page.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");

        }else{
            System.out.println("Undefined page");
        }
    }

    @When("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);

    }

    @When("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @When("I type {string} into group field")
    public void iTypeIntoGroupField(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @When("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);

    }

    @When("I type {string} into confirmPassword field")
    public void iTypeIntoConfirmPasswordField(String confPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confPassword);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) throws InterruptedException {
        getDriver().findElement(By.xpath("//span[text()='"+btnName+"']")).click();
        Thread.sleep(2000);
    }

    @Then("confirmation message {string} is displayed")
    public void confirmationMessageIsDisplayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-card[@class='mat-card']/h4")).getText();
        assertThat(actualMessage.equals(message)).isTrue();
    }
}
