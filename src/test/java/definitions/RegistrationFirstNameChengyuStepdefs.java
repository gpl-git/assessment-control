package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationFirstNameChengyuStepdefs {
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
    public void iClickTheButton(String RegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @When("I clear first name file")
    public void iClearFirstNameFile() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).clear();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-8']")).getText();
        assertThat(actualMessage.equals(expectedMessage)).isTrue();
    }
}
