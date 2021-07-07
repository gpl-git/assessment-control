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
    public void iGoToPage(String page) {
        switch (page){
            case "login":{
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            }
            case "registration":{
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            } default:{
                System.out.println("The site " + page + " is not supported");
            }
        }

    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec *1000);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span[text()='"+btnName+"']")).click();
    }

    @Then("I verify current url as {string}")
    public void iVerifyCurrentUrlAs(String curUrl) {
        String actualUrl = getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(curUrl)).isTrue();
    }

    @When("I click on {string} tab")
    public void iClickOnTab(String tab) {
        getDriver().findElement(By.xpath("//h5[text()='"+tab+"']")).click();
    }

    @And("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+questionType+"')]")).click();
    }


    @When("I type question text {string} into {string}")
    public void iTypeQuestionTextInto(String questionText, String qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I type {string} as option {string} into {string}")
    public void iTypeAsOptionInto(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../../mat-radio-button")).click();
    }
}
