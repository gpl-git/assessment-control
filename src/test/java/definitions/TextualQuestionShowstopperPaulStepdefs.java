package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQuestionShowstopperPaulStepdefs {
    @Given("I navigate to login page")
    public void iNavigateToLoginPage() {
        getDriver().get("http://ask-qa.portnov.com");
    }

    @When("I insert {string} into email field")
    public void iInsertIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
    }

    @Then("I insert {string} into password field")
    public void iInsertIntoPasswordField(String pass) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pass);
    }

    @And("I press {string} button")
    public void iPressButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @And("I go to {string} menu option")
    public void iGoToMenuOption(String menuOpt) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuOpt+"')]")).click();
    }

    @And("I wait about {int} sec")
    public void iWaitAboutSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @And("I type {string}")
    public void iType(String quizName) {
        getDriver().findElement(By.xpath("//*[@placeholder='Title Of The Quiz *']")).sendKeys(quizName);
    }

    @And("I press {string} icon")
    public void iPressIcon(String arg0) {

    }

    @And("I press - Add Question")
    public void iPressAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select Textual question")
    public void iSelectTextualQuestion() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Textual')]")).click();
    }

    @And("I ask my question - {string}")
    public void iAskMyQuestion(String question) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(question);
    }

    @Then("I mark question like Showstopper")
    public void iMarkQuestionLikeShowstopper() {
        getDriver().findElement(By.xpath("//label[@class='mat-checkbox-layout']")).click();
    }

    @Then("I select {string} quiz")
    public void iSelectQuiz(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]")).click();
    }


    @And("I click on question name")
    public void iClickOnQuestionName() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1*: Question')]")).click();
    }

    @And("I make sure that Showstopper score is available")
    public void iMakeSureThatShowstopperScoreIsAvailable() {
        assertThat(getDriver().findElement(By.xpath("//label[@class='mat-checkbox-layout']")).isDisplayed()).isTrue();
    }


    @Then("I delete this quiz {string}")
    public void iDeleteThisQuiz(String quizName) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("I press Edit button for {string} quiz")
    public void iPressEditButtonForQuiz(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../..//span[contains(text(),'Edit')]")).click();
    }

    @Then("I press Preview button for {string} quiz")
    public void iPressPreviewButtonForQuiz(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizName+"')]/../../..//span[contains(text(),'Preview')]"));
    }



    @Then("I go back")
    public void iGoBack() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Back To Quizzes List')]")).click();
    }



    @Then("I make sure that The question number is displayed with an asterisk – Q* once the show-stopper checkmark is selected")
    public void iMakeSureThatTheQuestionNumberIsDisplayedWithAnAsteriskQOnceTheShowStopperCheckmarkIsSelected() {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1*: Question')]")).equals("Q1*: Question"));
    }

    @Then("I make sure that Quiz with a showstopper in Preview displays a red label")
    public void iMakeSureThatQuizWithAShowstopperInPreviewDisplaysARedLabel() {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).isDisplayed()).isTrue();
    }

    @And("I ask my another question - {string}")
    public void iAskMyAnotherQuestion(String question) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'new empty question')]/../../..//textarea[@formcontrolname='question']")).sendKeys(question);
    }
}
