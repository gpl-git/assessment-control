package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import support.TestContext;

public class quizTotalQuestionsIvanovaStepdefs {

    //Delete QUIZ
    @And("I delete {string}")
    public void iDelete(String title) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'Delete')]")).click();
    }

    //Verify total Number of Questions in Quiz card
    @And("quiz {string} should have {string} total questions")
    public void quizShouldHaveTotalQuestions(String title, String qnum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).click(); //open Quiz card
        Thread.sleep(1000);
        String totalQuestion = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//tr[1]")).getText(); //get number of questions
        System.out.println(totalQuestion); // Total number : *
        assertThat(totalQuestion.contains(qnum)).isTrue(); //number in card = number in step

    }

    @Then("I create {int} {string} questions with text {string}")
    //Create n questions, choose Question type, add question text
    public void iCreateQuestionsWithText(Integer numOfQuestion, String questionType, String questionText) throws InterruptedException {
        //Create Textual question
        if (questionType.equalsIgnoreCase("Textual")) {
            for (int i = 1; i <= numOfQuestion; i++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click(); //Click on "Add Question"
                Thread.sleep(1000);
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'" + questionType + "')]")).click(); // Choose Question Type Textual
                getDriver().findElement(By.xpath("//*[contains(text(), 'Q" + i + "')]/../../..//*[@formcontrolname='question']")).sendKeys(questionText + i); //Add Question text
                Thread.sleep(1000);
            }
        } //Create Single-Choise question
        else if (questionType.equalsIgnoreCase("Single-Choice")) {
            for (int i = 1; i <= numOfQuestion; i++) {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click(); //Click on "Add Question"
                Thread.sleep(1000);
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'" + questionType + "')]")).click(); // Choose Question Type SC
                getDriver().findElement(By.xpath("//*[contains(text(), 'Q" + i + "')]/../../..//*[@formcontrolname='question']")).sendKeys(questionText + i); //Add Question text
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//textarea[contains(@placeholder,'Option 1*')]")).sendKeys("Option 1"); //Add Option text
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//textarea[contains(@placeholder,'Option 2*')]")).sendKeys("Option 2");//Add Option text
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Option 1*']/../../../../..//mat-radio-button")).click(); //Choose correct answer
                Thread.sleep(1000);
            }
        }
        else{
            System.out.println(questionType + " is not supported");
        }
    }

    @Then("I click button Add Question")
    public void iClickButtonAddQuestion() throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click(); //Click on "Add Question"
        Thread.sleep(1000);

    }

    //Error-message after click on button Add Question to add 51st question "No more than 50 questions"
    @And("error-message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
    String error = getDriver().findElement(By.xpath("//*[contains(text(), '"+errorMessage+"')]")).getText();
        System.out.println(error);
        assertThat(error.contains(errorMessage)).isTrue();
    }
}


