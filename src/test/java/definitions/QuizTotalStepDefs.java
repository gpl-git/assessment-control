package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalStepDefs {

    private int count;

    @When("I check {string} check-box as correct option in {string}")
    public void iCheckCheckBoxAsCorrectOptionIn(String optionNum, String questionNum) { //go up, widen /..
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']/../../../../..//*[contains(@class,'mat-checkbox-inner')]")).click();
    }

    @And("I wait untill Quizzes page is fully loaded by {string} button")
    public void iWaitUntillQuizzesPageIsFullyLoadedByButton(String buttonName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+buttonName+"']/../../button")));
    }

    @And("I verify the number of questions of {string}")
    public void iVerifyTheNumberOfQuestionsOf(String title) {
        String strActual = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../..//mat-panel-description")).getText();
        String strOnlyIntActual = strActual.replaceAll("[^0-9]", "");
        int intActual = Integer.parseInt(strOnlyIntActual);
        assertThat(count == intActual);
    }

    @When("I add a new question")
    public void iAddANewQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
        count++;
    }
}
