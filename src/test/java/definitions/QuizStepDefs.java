package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        if(url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int num) throws InterruptedException {
        Thread.sleep(num* 1000);
    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[text()='"+menuItem+"']")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string}")
    public void iTypeInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname ='question']")).sendKeys(questionText);
    }

    @And("I type {string} as {string} into {string}")
    public void iTypeAsInto(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }

    @Then("I select {string}  as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} is displayed on the list of quizzes")
    public void quizIsDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete quiz {string}")
    public void iDeleteQuiz(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
