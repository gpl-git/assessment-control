package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @Then("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[text()='"+link+"']")).click();
    }

    @Then("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} type")
    public void iSelectType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+type+"')]")).click();
    }

    @When("I type {string} as question {string} option {string}")
    public void iTypeAsQuestionOption(String text, String question, String option) {
        String xpath = "//*[contains(text(),'"+question+"')]/../../..//*[@placeholder='"+option+"']";
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @When("I add up to {int} questions")
    public void iAddUpToQuestions(int num) throws InterruptedException {
        for (int i = 2 ; i<=num ; i++){
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(300);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q"+i+"')]/../../..//*[contains(text(),'Textual')]")).click();
            String xpath = "//*[contains(text(),'Q"+i+"')]/../../..//*[@placeholder='Question *']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Test");
        }

    }

    @Then("{string} is displayed on the list of quizzes")
    public void iEditOnTheListOfQuizzes(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        Thread.sleep(2000);
        WebElement edit = getDriver().findElement(By.xpath("//span[contains(text(),'Edit')]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()",edit);

//        getDriver().findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).clear();
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title+"_UPDATED");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        Thread.sleep(2000);
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"_UPDATED"+"')]")).isDisplayed()).isTrue();

    }

    @Then("I check {string} as correct answer in question {string}")
    public void iCheckAsCorrectAnswerInQuestion(String option, String question) {
        String xpath = "//*[contains(text(),'"+question+"')]/../../..//*[@placeholder='"+option+"']/../../../../..//*[input]";
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("I add {int} more options to {string}")
    public void iAddMoreOptionsTo(int number, String question) {
        String option = "Option ";
        String btnAddQuestion = "//*[contains(text(),'"+question+"')]/../../..//*[contains(text(), 'Add Option')]";
        for (int i = 0 ; i<=number-1 ; i++){
            getDriver().findElement(By.xpath(btnAddQuestion)).click();
        }

    }

    @Then("I select radio button {string} as correct answer in question {string}")
    public void iSelectRadioButtonAsCorrectAnswerInQuestion(String option, String question) {
        String xpath = "//*[@placeholder='"+option+"']/../../../../..//*[@class='mat-radio-inner-circle']";
        WebElement correctRadio = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", correctRadio);

    }
}
