package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        if(url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("The site " + url+ " is not supported");
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

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();


    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[text()='"+link+"']")).click();
    }

    @And("I type {string} as the quiz title")
    public void iTypeAsTheQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string}")
    public void iTypeInto(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type{string} as {string} into {string}")
    public void iTypeAsInto(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']")).sendKeys(optionText);
    }

        @And("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-radio-button")).click();

    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string}")
    public void iDelete(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class ='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);

    }
}
