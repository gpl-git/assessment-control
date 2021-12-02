package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class PassConfirmPassStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if(url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("The site " + url+ " is not supported");
        }
    }

    @When("I type {string} into First Name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("I type {string} into Last Name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("I type {string} into Email field")
    public void iType(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into Group Code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @Then("I validate password field displays error message {string}")
    public void iValidatePasswordFieldDisplaysErrorMessage(String message) {
        String actual = getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../..//mat-error")).getText();
        System.out.println(actual);
        assertThat(actual.equals(message));

    }

    @Then("I type {string} into Password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I validate confirm password field displays error message {string}")
    public void iValidateConfirmPasswordFieldDisplaysErrorMessage(String confPassMessage) {
        String actual = getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']/../../..//mat-error")).getText();
        System.out.println(actual);
        assertThat(actual.equals(confPassMessage));

    }

    @When("I type {string} into Confirm Password field")
    public void iTypeIntoConfirmPasswordField(String confirmPass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPass);
    }


    @Then("I switch to new window")
    public void iSwitchToNewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while(iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
    }

    @Then("I validate that message {string} is displayed")
    public void iValidateThatMessageIsDisplayed(String registeredMessage) {
      String result = getDriver().findElement(By.xpath("//h4")).getText();
      assertThat(result.contains(registeredMessage));
    }

}
