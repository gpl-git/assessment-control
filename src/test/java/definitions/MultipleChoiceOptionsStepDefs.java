package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceOptionsStepDefs {
    @Then("{string} should appear")
    public void shouldAppear(String message) {
        String actualMessage = getDriver().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).getText();
        assertThat(actualMessage).isEqualTo(message);
}

    @Then("quiz {string} shouldn't be displayed on the list of quizzes")
    public void quizShouldnTBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isFalse();
    }

    @When("I click on add option")
    public void iClickOnAddOption() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Add Option')]")).click();
    }


    @When("I type {string} {int} characters as question {string} option field {string}")
    public void iTypeCharactersAsQuestionOptionField(String text, int length, String questionNumber, String optionNumber) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length,useLetters, useNumbers);
        text = generatedString;
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='"+optionNumber+"']")).sendKeys(text);

    }

    @When("I add option in {string} question up to {int} choices")
    public void iAddOptionInQuestionUpToOptions(String questionNumber, int numberOptions) {
        String addButton = "//*[contains(text(),'Q1')]/../../..//*[contains(text(),'Add Option')]";
        for (int i=3; i<=numberOptions; i++){
            getDriver().findElement(By.xpath(addButton)).click();
            String xpath = "//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Option "+i+"*']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Option " + i);

        }

    }
}
