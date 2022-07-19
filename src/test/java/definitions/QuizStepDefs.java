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
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This sie " +url + " is not supported.");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} as password")
    public void iEnterAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+ questionType+"')]")).click();
    }

    @And("I type {string} into {string}")
    public void iTypeInto(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@formcontrolname ='question']")).sendKeys(questionText);
    }

    @When("I type {string} as {string} into {string}")
    public void iTypeAsInto(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder ='"+optionNumber+"']")).sendKeys(optionText);
    }

    @And("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder ='"+optionNumber+"']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string}")
    public void iDelete(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }


    @Then("quiz {string} should not be displayed on the list of quizzes")
    public void quizShouldNotBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isFalse();
    }

    @And("I click outside")
    public void iClickOutside() {
        getDriver().findElement(By.xpath("//ac-quiz-builder-page")).click();
    }

    @Then("I get error {string}")
    public void iGetError(String error) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualError.equals(error)).isTrue();

    }
}
