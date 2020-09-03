package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LastNameStepdefs {
    @Then("error message {string} is displayed")
    public void errorMessageIsDispayed(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[@class=\"mat-error ng-star-inserted\"]")).getText();
        assertThat(message.equals(actualMessage)).isTrue();
    }


    @When("I type {string} into login email field")
    public void iTypeIntoLoginEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(email);
    }

    @And("I type {string} into login password field")
    public void iTypeIntoLoginPasswordField(String Password) {
        getDriver().findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(Password);
    }

    @Then("I sign in")
    public void iSignIn() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String Quiz) {
        getDriver().get("http://ask-qa.portnov.com/#/quiz-builder");
    }

    @Then("I click on {string}")
    public void iClickOn(String newQuiz) {
        getDriver().findElement(By.linkText("Create New Quiz")).click();
    }

    @Then("error {string} is displayed")
    public void errorIsDisplayed(String error) {
        String actualMessage = getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']")).getText();
        assertThat(error.equals(actualMessage)).isTrue();

    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 2000);

    }
}
