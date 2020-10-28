package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class QuizStepdefs {
    @And("I enter {string} as quiz title")
    public void iEnterAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @Then("I add question")
    public void iAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I select {string} question type")
    public void iSelectQuestionType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+type+"')]")).click();
    }

    @When("I type {string} into {string} as {string}")
    public void iTypeIntoAs(String questionText, String questionN, String questionTitle) {
        String xpath = "//mat-panel-title[contains(text(),'"+questionN+"')]/../../../..//*[@placeholder='"+questionTitle+"']";
        getDriver().findElement(By.xpath(xpath)).sendKeys(questionText);
    }

    @When("I type {string} into {string} as {string} question option")
    public void iTypeIntoAsQuestionOption(String optionText, String questionN, String option) {
        String xpath = "//mat-panel-title[contains(text(),'"+questionN+"')]/../../../..//*[@placeholder='"+option+"']";
        getDriver().findElement(By.xpath(xpath)).sendKeys(optionText);
    }

    @And("I check {string} as correct  in question {string}")
    public void iCheckAsCorrectInQuestion(String option, String questionN) {
        String xpath = "//mat-panel-title[contains(text(),'"+questionN+"')]/../../../..//*[@placeholder='"+option+"']/../../../../..//*[input]";
        getDriver().findElement(By.xpath(xpath)).click();
    }
}
