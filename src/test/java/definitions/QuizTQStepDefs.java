package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTQStepDefs {
  @Then("I am creating {int} {string} questions")
  public void iAmCreatingQuestions(int questionNumbers, String questionType) throws InterruptedException {
    for (int i = 1; i <= questionNumbers; i++) {
      getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
      Thread.sleep(1000);
      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q"+String.valueOf(i)+"')]/../../..//*[contains(text(),'"+questionType+"')]")).click();
      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q"+String.valueOf(i)+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys("Question "+ String.valueOf(i));
    }
  }

  @Then("Question {int} should be displayed on the list of preview mode")
  public void questionShouldBeDisplayedOnTheListOfPreviewMode(int totalQuestions) {
    assertThat(getDriver().findElement(By.xpath("//mat-card/h5[contains(text(),'Question "+String.valueOf(totalQuestions)+"')]")).isDisplayed()).isTrue();
  }

  @Then("{int} total number of Questions for {string} should be displayed on the list of quizzes")
  public void totalNumberOfQuestionsForShouldBeDisplayedOnTheListOfQuizzes(int totalQuestions, String title) {
    assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/..//mat-panel-description[contains(text(),'"+String.valueOf(totalQuestions)+"')]")).isDisplayed()).isTrue();
  }
}