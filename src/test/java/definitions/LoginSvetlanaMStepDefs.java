package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class LoginSvetlanaMStepDefs {
    

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }



    @Then("{string} page should be displayed")
    public void pageShouldBeDisplayed(String expectedUrl) {
       String actualUrl = getDriver().getCurrentUrl();
       assertThat(actualUrl.contains(expectedUrl)).isTrue();
    }

    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(), 'Authentication failed. User not found or password does not match')]")).getText();
        assertThat(actualMessage.contains(errorMessage)).isTrue();
    }

    @Then("password error message {string} is displayed")
    public void passwordErrorMessageIsDisplayed(String errorPassword) {
        String actualError = getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../..//mat-error[contains(text(), '"+errorPassword+"')]")).getText();
        assertThat(actualError.equals(errorPassword)).isTrue();
    }

    @Then("{string} page should not be displayed")
    public void pageShouldNotBeDisplayed(String expectedUrl) {
        String actualUrl = getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(expectedUrl)).isFalse();
    }

    @Then("email error message {string} is displayed")
    public void emailErrorMessageIsDisplayed(String errorEmail) {
        String actualError = getDriver().findElement(By.xpath("//input[@formcontrolname='email']/../../..//mat-error[contains(text(), '"+errorEmail+"')]")).getText();
        assertThat(actualError.equals(errorEmail)).isTrue();
    }

    @Then("I verify that password field is masked")
    public void iVerifyThatPasswordFieldIsMasked() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type")).isEqualTo("password");
    }

    @And("I click into password field")
    public void iClickIntoPasswordField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).click();
    }

    @And("I click into email field")
    public void iClickIntoEmailField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).click();
    }

    @And("I verify user role is {string}")
    public void iVerifyUserRoleIs(String role) {
        String  userInfo=getDriver().findElement(By.xpath("//div[@class='info']")).getText();
        assertThat(userInfo.contains(role.toUpperCase(Locale.ROOT))).isTrue();
    }

    @Then("I verify that password field has attribute type=password")
    public void iVerifyThatPasswordFieldHasAttributeTypePassword() {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute("type")).isEqualTo("password");

    }

    @Given("I navigate to {string} page SM")
    public void iNavigateToPageSM(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");

        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I click button {string} SM")
    public void iClickButtonSM(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(), '"+buttonName+"')]")).click();
    }
}
