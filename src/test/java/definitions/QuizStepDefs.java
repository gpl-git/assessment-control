package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equalsIgnoreCase("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equalsIgnoreCase("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site " +url+ " is not supported");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @And("I click on {string} link")
    public void iClickOnLink(String link) {
        getDriver().findElement(By.xpath("//h5[text()='"+link+"']")).click();
    }

    @Given("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} question type")
    public void iSelectQuestionType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+type+"')]")).click();
    }

    @When("I type {string} as question {string} text field {string}")
    public void iTypeAsQuestionTextField(String questionText, String questionNumber, String questionField) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I type {string} as question {string} option field {string}")
    public void iTypeAsQuestionOptionField(String text, String questionNumber, String optionNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='"+optionNumber+"']")).sendKeys(text);
    }

    @When("I check {string} as correct answer in {string}")
    public void iCheckAsCorrectAnswerIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='"+optionNumber+"']/../../../../../mat-checkbox")).click();

    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} from the list of quizzes")
    public void iDeleteFromTheListOfQuizzes(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+quizTitle+"')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[text()='Delete']")).click();
        Thread.sleep(2000);


    }
}
