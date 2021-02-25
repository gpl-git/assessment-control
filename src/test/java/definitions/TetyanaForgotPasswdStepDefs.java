package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class TetyanaForgotPasswdStepDefs {
    @Given("I go the webpage {string}")
    public void iGoTheWebpage(String webpage) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @And("I enter a valid email")
    public void iEnterAValidEmail() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("tet801@gmail.com");
    }

    @When("I click on {string}")
    public void iClickOn(String iForgotMyPassword) {
        getDriver().findElement(By.xpath("//a[contains(text(),'I forgot my password')]")).click();
    }

    @And("click on the button {string}")
    public void clickOnTheButton(String requestPasswordReset) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @And("I enter an invalid email")
    public void iEnterAnInvalidEmail() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("th@main.com");
    }

    @Then("the error message {string} is displayed.")
    public void theErrorMessageIsDisplayed(String text) {
        String info = getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Authentication failed')]")).getText();
        assertThat(info.contains(text)).isTrue();
    }

    @And("I leave the email field empty")
    public void iLeaveTheEmailFieldEmpty() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("");
    }

    @Then("I verify the error message {string} will be displayed")
    public void iVerifyTheErrorMessageWillBeDisplayed(String text) {
        String info = getDriver().findElement(By.xpath("//div[@class='mat-input-subscript-wrapper mat-form-field-subscript-wrapper']")).getText();
        assertThat(info.contains(text)).isTrue();
    }

    @Given("I go to url {string} page")
    public void iGoToUrlResetPasswordPage(String resetPassword1) {
        getDriver().get("http://ask-qa.portnov.com/#/reset-password/1469/11182177c80aed8e6db814b15be046d16a91a1e1");

    }

    @Then("{string} window is displayed")
    public void windowIsDisplayed(String window) {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).isDisplayed();

    }

    @And("I type {string} in the New Password field")
    public void iTypeInTheNewPasswordField(String newPassword) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("12345");
    }

    @And("I type {string} in the Confirm New Password field")
    public void iTypeInTheConfirmNewPasswordField(String ConfirmNewPassword) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("56789");
    }

    @And("I  enter old password  in  New Password field")
    public void iEnterOldPasswordInNewPasswordField() {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("12345");
    }

    @And("I enter same old password in Confirm New Password")
    public void iEnterSameOldPasswordInConfirmNewPassword() {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("12345");
    }

    @Then("Your Password was Changed message is displayed")
    public void yourPasswordWasChangedMessageIsDisplayed() {
        getDriver().findElement(By.xpath("//h4[contains(text(),'Your Password was Changed')]")).isDisplayed();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String text) {
        String info = getDriver().findElement(By.xpath("//*[contains(text(),'Entered passwords should match')]")).getText();
        assertThat(info.contains(text)).isTrue();
    }

    @And("I press {string} button")
    public void iPressButton(String button) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I see a message {string}")
    public void iSeeAMessage(String message) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'Your request is confirmed')]")).isDisplayed();
    }

    @Then("I go to url {string}")
    public void iGoToUrl(String restPassword) {
        getDriver().get("http://ask-qa.portnov.com/#/reset-password/1469/38eb76e2ba7379258f05b10bedabf5436ccdadde");
    }

    @Then("I enter my email in the email field")
    public void iEnterMyEmailInTheEmailField() {
        getDriver().findElement(By.xpath("//div[@class='mat-input-flex mat-form-field-flex']")).sendKeys("z_tetyana@yahoo.com");
    }
}