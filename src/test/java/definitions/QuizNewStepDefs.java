package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
public class QuizNewStepDefs {
    @Given("First I open {string} page")
    public void firstIOpenPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url is not supported: " + url);
        }

    }

    @And("I wait for {int} Seconds")
    public void iWaitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @When("I type email {string} for teacher")
    public void iTypeEmailForTeacher(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} password")
    public void iTypePassword(String password) {
       getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string}")
    public void iClick(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @Then("{string} page displayed")
    public void pageDisplayed(String expectedUrl) {
        String curUrl = getDriver().getCurrentUrl();
        assertThat(curUrl.contains(expectedUrl)).isTrue();
    }

    @When("I click on {string} menu")
    public void iClickOnMenu(String menu) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menu + "')]")).click();
    }

    @When("I type context {string} as quiz title")
    public void iTypeContextAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add question")
    public void iAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType +"')]")).click();
    }

    @When("I enter {string} into {string}")
    public void iEnterInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../.. //textarea[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("I type {string} as {string} in {string} question")
    public void iTypeAsInQuestion(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../.. //textarea[@placeholder='" + optionNum + "']")).sendKeys(optionText);
    }


    @Then("I select {string} as correct in option {string}")
    public void iSelectAsCorrectInOption(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+ questionNum+"')]/../../.. //textarea[@placeholder='" + optionNum + "']/../../../../../mat-radio-button")).click();
    }

    @Then("qiiz {string} is displayed on the list of quizzes")
    public void qiizIsDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+ title +"')]")).isDisplayed()).isTrue();
    }

    @And("I delete quiz  {string}")
    public void iDeleteQuiz(String title) throws InterruptedException {
       getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+ title +"')]")).click();
       getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//*[contains(text(),'Delete')]")).click();
       getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
       Thread.sleep(1000);

    }
}
