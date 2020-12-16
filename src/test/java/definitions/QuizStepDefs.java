package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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


    @Then("I type {string} in question text field and create {int} {string} questions")
    public void iTypeInQuestionTextFieldAndCreateQuestions(String q, int numq, String type) throws InterruptedException {
        for(int i = 2; i <= numq; i++){
            getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
            Thread.sleep(1 * 1000);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q"+i+"')]/../../..//*[contains(text(),'Textual')]")).click();
            Thread.sleep(1 * 1000);
            getDriver().findElement(By.xpath(("//mat-panel-title[contains(text(),'Q" + i +  "')]/../../..//textarea[@placeholder='Question *']"))).sendKeys(q);

            Thread.sleep(1 * 1000);


        }
    }

    @Then("I type {string} in question text field and create {string} questions")
    public void iTypeInQuestionTextFieldAndCreateQuestions(String q, String type) throws InterruptedException {

        getDriver().findElement(By.xpath("//div[@class='mat-radio-label-content'][contains(text(),'Textual')]")).click();
        Thread.sleep(1 * 1000);
        getDriver().findElement(By.xpath(("//mat-panel-title[contains(text(),'Q')]/../../..//textarea[@placeholder='Question *']"))).sendKeys(q);
        Thread.sleep(1 * 1000);
    }

    @Then("I save my quiz")
    public void iSaveMyQuiz() {getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }


    @Then("I verify {int} of created question")
    public void iVerifyOfCreatedQuestion(int num) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Bohdan Lypko1')]")).click();
        Thread.sleep(1 * 1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Bohdan Lypko1')]/../../..//*[contains(text(),'Preview')]")).click();
        Thread.sleep(1 * 1000);
        getDriver().findElement(By.xpath("//h5[contains(text(),'Question 1 / " + num + "')]")).isDisplayed();
        Thread.sleep(1 * 1000);


    }

    @Then("I verify {int} created question with quizz name {string}")
    public void iVerifyCreatedQuestionWithQuizzName(int num, String name) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + name + "')]")).click();
        Thread.sleep(1 * 1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + name + "')]/../../..//*[contains(text(),'Preview')]")).click();
        Thread.sleep(1 * 1000);

        if (getDriver().findElement(By.xpath("//h5[contains(text(),'Question 1 / " + num + "')]")).isDisplayed()){
            System.out.println("Test fail we have limit of 50 but we have " + num);
        }else {
            System.out.println("We have " + num + "question with limit of 50");
        }
    }
}
