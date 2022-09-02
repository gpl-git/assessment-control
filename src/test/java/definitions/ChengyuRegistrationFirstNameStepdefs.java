package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ChengyuRegistrationFirstNameStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("I click the {string} button")
    public void iClickTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @When("I clear first name file")
    public void iClearFirstNameFile() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }

    @When("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

    }

    @And("I see message {string} is displayed")
    public void iSeeMessageIsDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();

    }

    @And("a error message {string} is displayed")
    public void aErrorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }

    @And("a error message {string} should be present")
    public void aErrorMessageShouldBePresent(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();

    }

    @And("another error message {string} is displayed")
    public void anotherErrorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }
}
