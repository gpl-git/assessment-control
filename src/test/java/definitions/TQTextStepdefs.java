package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static  org.assertj.core.api.Assertions.assertThat;
public class TQTextStepdefs {


    @When("I type {string} into textual question text field of {string}")
    public void iTypeIntoTextualQuestionTextFieldOf(String text, String questionNumber) {

        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea")).sendKeys(text);
    }



    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String error) {
        String message = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(message.equals(error)).isTrue();
    }
}
