package defenitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDef {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site" + url + " is not supported");
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
    public void iTypeIntoPasswordField(String passwword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(passwword);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I click on {string} link")
    public void iClickOnLink(String link) {
        getDriver().findElement(By.xpath("//h5[text()='" + link + "']")).click();
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
        getDriver().findElement(By.xpath("//*[contains(text(),'" + type + "')]")).click();
    }

    @When("I type {string} as question {string} text field {string}")
    public void iTypeAsQuestionTextField(String questionText, String questionNumber, String questionField) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionNumber + "')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I type {string} as question {string} option field {string}")
    public void iTypeAsQuestionOptionField(String text, String questionNumber, String optionNumber) {
        int length = 1000;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        text = generatedString;
        getDriver().findElement(By.xpath("//*[contains(text(), '" + questionNumber + "')]/../../..//*[@placeholder='" + optionNumber + "']")).sendKeys(text);
    }

    @When("I check {string} as correct answer in {string}")
    public void iCheckAsCorrectAnswerIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionNumber + "')]/../../..//*[@placeholder='" + optionNumber + "']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzess")
    public void quizShouldBeDisplayedOnTheListOfQuizzess(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} from the list of quizzes")
    public void iDeleteFromTheListOfQuizzes(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[text()='Delete']")).click();
        Thread.sleep(2000);
    }


    @When("I add options in {string} up to {int}")
    public void iAddOptionsInUpTo(String questionNumber, int numberOption) throws InterruptedException {
        String buttonAdd = "//*[contains(text(),'" + questionNumber + "')]/../../..//*[contains(text(),'Add Option')]";
        for (int i = 3; i <= numberOption; i++) {
            getDriver().findElement(By.xpath(buttonAdd)).click();
            String xpath = "//*[contains(text(),'" + questionNumber + "')]/../../..//*[@placeholder = 'Option " + i + "*']";
            Thread.sleep(1000);
            getDriver().findElement(By.xpath(xpath)).sendKeys("Option " + i);
        }
    }

    @Then("quiz {string} shouldn`t be displayed on the list of quizzess")
    public void quizShouldnTBeDisplayedOnTheListOfQuizzess(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isFalse();
    }

    @Then("{string} should appear")
    public void shouldAppear(String error) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), 'Check highlighted')]")).isDisplayed()).isTrue();
    }

    @And("I type {string} as question {string} option {string}")
    public void iTypeAsQuestionOption(String text, String questionNumber, String optionNumber) {
        int length = 1;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        text = generatedString;
        getDriver().findElement(By.xpath("//*[contains(text(), '" + questionNumber + "')]/../../..//*[@placeholder='" + optionNumber + "']")).sendKeys(text);
    }

    @When("I add options in {string} more than {int}")
    public void iAddOptionsInMoreThan(String questionNumber, int numberOption) throws InterruptedException {
        String buttonAdd = "//*[contains(text(),'" + questionNumber + "')]/../../..//*[contains(text(),'Add Option')]";
        for (int i = 3; i <= numberOption; i++) {
            getDriver().findElement(By.xpath(buttonAdd)).click();
            String xpath = "//*[contains(text(),'" + questionNumber + "')]/../../..//*[@placeholder = 'Option " + i + "*']";
            Thread.sleep(1000);
            getDriver().findElement(By.xpath(xpath)).sendKeys("Option " + i);
        }
    }

    @And("I type {string} as question {string} opt field {string}")
    public void iTypeAsQuestionOptField(String text, String questionNumber, String optionNumber) {
        int length = 1001;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        text = generatedString;
        getDriver().findElement(By.xpath("//*[contains(text(), '" + questionNumber + "')]/../../..//*[@placeholder='" + optionNumber + "']")).sendKeys(text);
    }
}
