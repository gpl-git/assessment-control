package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class QuizTotalStepDefs { //go up, widen /..
    @When("I check {string} check-box as correct option in {string}")
    public void iCheckCheckBoxAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']/../../../../..//*[contains(@class,'mat-checkbox-inner')]")).click();

    }

    @And("I wait untill Quizzes page is fully loaded by {string} button")
    public void iWaitUntillQuizzesPageIsFullyLoadedByButton(String buttonName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+buttonName+"']/../../button")));
    }
}
