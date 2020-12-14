package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class QuizStepDefs {
    @And("I type {string} as title")
    public void iTypeAsTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select question type {string}")
    public void iSelectQuestionType(String type) {
        getDriver().findElement(By.xpath("//div[@class='mat-radio-label-content'][contains(text(),'"+type+"')]")).click();
    }

    @When("I type {string} into question{string} as {string}")
    public void iTypeIntoQuestionAs(String questionText, String questionNumber, String questionField) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+questionField+"']")).sendKeys(questionText);
    }


    @When("I check {string} as correct in question {string}")
    public void iCheckAsCorrectInQuestion(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+optionNum+"']/../../../../../mat-radio-button")).click();

    }
}
