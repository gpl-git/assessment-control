package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
//import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GroupCodeTejalDefs {
    @Given("I OPEN  {string} page")
    public void iOPENPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/registration");
    }


    @And("I type {string} into firstName field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);

    }

    @Then("I type {string} into lastName field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);

    }

    @Then("I type {string} into email input field")
    public void iTypeIntoEmailInputField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);

    }

    @Then("I type {string} into groupCode field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @Then("I type {string} into password field field")
    public void iTypeIntoPasswordFieldField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I type {string} into  Confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmaPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmaPassword);

    }


    //    @Given("I click on groupCode field")
//    public void iClickOnGroupCodeField() {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).click();
    @Given("I clear on groupCode field")
    public void iClearOnGroupCodeField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).clear();

    }

    @Then("I type {string} into groupCode")
    public void iTypeIntoGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);

    }

    @Then("I click on {string} button")
    public void iClickOnButton(String register) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("Error message should be appeared")
    public void errorMessageShouldBeAppeared() {
        getDriver().findElement(By.xpath("//div[@class='ng-tns-c9-7 ng-trigger ng-trigger-transitionMessages ng-star-inserted']")).isDisplayed();
    }

    @Then("Error Message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) {

        String ActualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(ActualError.contains(expectedError)).isTrue();
    }


    @And("I wait for more  {int} sec")
    public void iWaitForMoreSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }


    @Given("I again clear on groupCode field")
    public void iAgainClearOnGroupCodeField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).clear();

    }


    @Then("I type {string} into  groupCode space")
    public void iTypeIntoGroupCodeSpace(String grpCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(grpCode);

    }


    @Then("I clear on groupCode field again")
    public void iClearOnGroupCodeFieldAgain() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).clear();


    }

    @Then("I click Register-me button")
    public void iClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();

    }

    @And("I get an error message")
    public void iGetAnErrorMessage() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']/../../..")).isDisplayed();

    }

    @Then("Error Message {string} should be there")
    public void errorMessageShouldBeThere(String errorMsg) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
    }

    @Given("I click on groupCode field")
    public void iClickOnGroupCodeField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).click();

    }

    @Then("I type {string} on groupCode field")
    public void iTypeOnGroupCodeField(String grpCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(grpCode);
    }

    @Then("submit the form")
    public void submitTheForm() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("error message {string} should be appeared")
    public void errorMessageShouldBeAppeared(String errMsg) {
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'Should no more than 10 characters')]")).getText();

    }
}