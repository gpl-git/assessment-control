package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceQuestionOptionsStepDefs {
    @When("I add {int} new option to {string}")
    public void iAddNewOptionTo(int optionCount, String questionNum) {
        for (int i=0; i<optionCount; i++){
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+(i+3)+"*']")).sendKeys("Option " + (i+3));
        }
    }

    @Then("quiz {string} should not be displayed on the list of quizzes")
    public void quizShouldNotBeDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isFalse();
    }

    @Then("The error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String errorMessage) {
        getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'"+errorMessage+"')]")).isDisplayed();
    }

    @And("I click on {string} in {string} in question {string}")
    public void iClickOnInInQuestion(String btnName, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../..//*[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("element {string} should be disabled")
    public void elementShouldBeDisabled(String btnName) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]/..")).isEnabled()).isFalse();
    }

    @Then("The sample in {string} should have {string} in {string}")
    public void theSampleInShouldHaveIn(String optionNum, String optionText, String questionNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).getText().equals(optionText));
    }



}
