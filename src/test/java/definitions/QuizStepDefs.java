package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class QuizStepDefs {
    @And("I enter {string} into quiz title field")
    public void iEnterIntoQuizTitleField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I select {string} question byDI")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+questionType+"')]")).click();
    }

    @And("I type {string} into {string} question input field")
    public void iTypeIntoQuestionInputField(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @Then("title {string} is displayed on the list of quizzes")
    public void titleIsDisplayedOnTheListOfQuizzes(String title) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element:titles) {
            if (element.getText().contains(title)){
                element.isDisplayed();
            }

        }

    }

    @And("I delete {string} quiz")
    public void git iDeleteQuiz(String title) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element:titles) {
            if (element.getText().contains(title)){
               element.click();
            }

        }


        WebElement element = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//*[text()='Delete']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


}
