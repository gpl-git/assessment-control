package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;





public class singleChoiceShowStopper {

    @Given("I go to the login {string} page")
    public void iGoToThePage(String url) {
        getDriver().get(url);
    }

    @When("I type {string} to the email")
    public void iTypeToTheEmail(String logInEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(logInEmail);
    }

    @And("I type {string} to the password")
    public void iTypeToThePassword(String password) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(password);
        Thread.sleep(1000);
    }


    @When("I click to the {string} button")
    public void iClickToTheButton(String button) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + button + "')]//..")).click();
        Thread.sleep(1000);
    }


    @When("I type {string} to the quiz title")
    public void iTypeToTheQuizTitle(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(quizTitle);
        Thread.sleep(1000);
    }


    @And("I select question type {string} for question {int}")
    public void iSelectQuestionTypeForQuestion(String qType, int qNumber) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'Q"+qNumber+"')]/../../..//*[contains(text(),'"+qType+"')]/..")).click();

    }

    @When("I type to the {string} text of question {string}")
    public void iTypeToTheTextOfQuestion(String questionNum, String questionText) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I type to the question number {string} for option number {string}   question answer {string}")
    public void iTypeToTheQuestionNumberForOptionNumberQuestionAnswer(String quesNum, String optionNum, String answerText) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quesNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(answerText);
        Thread.sleep(1000);
    }

    @Then("I select from question number {string} option number {string} as correct option")
    public void iSelectFromQuestionNumberOptionNumberAsCorrectOption(String quesnum, String optionNumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quesnum+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../..//mat-radio-button")).click();
        Thread.sleep(1000);
    }


//    @Then("I mark {string}")
//    public void iMark(String option) throws InterruptedException {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//span[contains(text(),'Show-Stopper')]")).click();
//        Thread.sleep(1000);
//
//    }

    @Then("I mark {string} as {string}")
    public void iMarkAs(String questionNum, String option) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'"+option+"')]")).click();
        Thread.sleep(1000);
    }
    @And("I assert if question marked as Show-Stopper")
    public void iAssertIfQuestionMarkedAsShowStopper() throws InterruptedException {
        //        and I assert if  "Show-Stopper" question? marked
        getDriver().findElement(By.xpath("//mat-checkbox[@class='mat-checkbox mat-accent mat-checkbox-anim-unchecked-checked mat-checkbox-checked']")).isDisplayed();
        Thread.sleep(1000);

    }

    @Then("assert that quiz title {string} displayed on list of quizzes")
    public void assertThatQuizTitleDisplayedOnListOfQuizzes(String quizTitle) throws InterruptedException {
//        String quizTitleFromPage=getDriver().findElement(By.xpath(""));
//        assertEquals();

        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
        Thread.sleep(1000);
    }

    @Then("I click on title {string}")
    public void iClickOnTitle(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        Thread.sleep(1000);
    }


    @Then("I Preview {string} quiz")
    public void iPreviewQuiz(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]//..//..//..//span[text()='Preview']")).click();
        Thread.sleep(1000);
    }

    @And("I assert that question in quiz marked as {string}")
    public void iAssertThatQuestionInQuizMarkedAs(String asserttext) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'"+asserttext+"')]")).isDisplayed()).isTrue();
        Thread.sleep(1000);
    }

    @And("I delete the quiz {string}")
    public void iDeleteTheQuiz(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]//..//..//..//span[text()='Delete']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
    }

    @Then("I navigate back to {string}")
    public void iNavigateBackTo(String questionNum) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]")).click();
        Thread.sleep(1000);
    }


    @And("I verify Qone is not checked as show stopper")
    public void iVerifyQIsNotCheckedAsShowStopper() {
        getDriver().findElement(By.xpath("//input[@id='mat-checkbox-2-input' and @aria-checked='false']"));
    }



//    @Then("I assert that quiz title {string} NOT displayed on list of quizzes")
//    public void iAssertThatQuizTitleNOTDisplayedOnListOfQuizzes(String quizTitle) throws InterruptedException {
///        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isFalse();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]"));

//        try {
//            Assert.assertFalse(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed());
//        } catch(NoSuchElementException e) {
//            System.out.println("Element not displayed as expected");
//        }




}