package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class IgorMcqStepDefs {
    @Given("Igor go to {string}")
    public void igorGoTo(String url) {
            getDriver().get(url);
    }

    @When("Igor type {string} into Email field")
    public void igorTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("Igor type {string} into Password field")
    public void igorTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("Igor click button {string}")
    public void igorClickButton(String btnName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+btnName+"')]")).click();
        Thread.sleep(1000);
    }

    @And("Igor wait for {int} seconds")
    public void igorWaitForSeconds(int num) throws InterruptedException {
        Thread.sleep(1000);
    }

    @And("Igor type {string} as quiz title")
    public void igorTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("Igor add a question")
    public void igorAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("Igor select {string} question type")
    public void igorSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("Igor type {string} into {string}")
    public void igorTypeInto(String qText, String qNum) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+qNum+"')]/../../..//*[@placeholder='Question *']")).sendKeys(qText);
    }

    @And("Igor type {string} as {string} into {string}")
    public void igorTypeAsInto(String optText, String optNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+optNum+"']")).sendKeys(optText);
    }

    @When("Igor select {string} as correct option in {string}")
    public void igorSelectAsCorrectOptionIn(String optNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+optNum+"']/../../../../../mat-checkbox")).click();
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("quiz {string} gets up on the List of Quizzes")
    public void quizGetsUpOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("Igor delete quiz {string}")
    public void igorDeleteQuiz(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}