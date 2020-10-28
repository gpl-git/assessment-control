package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegTsvetoStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else {
            System.out.println("Unsupported site " + url);
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I type {string} as First Name")
    public void iTypeAsFirstName(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type {string} as Last Name")
    public void iTypeAsLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
}

    @And("I type {string} as Email")
    public void iTypeAsEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as Group Code")
    public void iTypeAsGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I type {string} as Password")
    public void iTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type {string} as Confirm Password")
    public void iTypeAsConfirmPassword(String confPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confPassword);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("confirmation message {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String message) {
        String messageText = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(message.equals(messageText)).isTrue();
    }

    @Then("I verify user role as {string}")
    public void iVerifyUserRoleAs(String userRole) {
        String userInfo = getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        assertThat(userInfo.contains(userRole)).isTrue();
    }



    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        String messageText = getDriver().findElement(By.xpath("//*[@id='mat-error-3']")).getText();
        assertThat(message.equals(messageText)).isTrue();
    }

    @And("I click on the {string} field")
    public void iClickOnTheField(String fieldName) {
        getDriver().findElement(By.xpath("//*[@id='mat-input-3,'"+fieldName+"')]")).click();


    }
}
