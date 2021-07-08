package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTextualSeemaStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
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

    @When("I type {string} into my email field")
    public void iTypeIntoMyEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string}as password")
    public void iTypeAsPassword(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);
    }

    @And("I wait for{int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }


    @When("I click  {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[text()='"+btnName+"']")).click();
    }

    @Then("I verify opened current url as {string}")
    public void iVerifyOpenedCurrentUrlAs(String curUrl) {
        String actualUrl=getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(curUrl)).isTrue();
    }

    @When("I click on tab {string}")
    public void iClickOnTab(String tab)  {

        getDriver().findElement(By.xpath("//h5[text()='"+tab+"']")).click();
    }
    @When("I click the {string} button")
    public void iClickTheButton(String bttn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }


    @When("I type {string} as Quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);

    }


    @When("I add question")
    public void iAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} as question type")
    public void iSelectAsQuestionType(String quesType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+quesType+"')]")).click();
    }

    @When("I type text {string} into{string}")
    public void iTypeTextInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I add second question")
    public void iAddSecondQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} as ques type")
    public void iSelectAsQuesType(String quesType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+quesType+"')]")).click();
    }

    @When("I type next text {string} into{string}")
    public void iTypeNextTextInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionText);
    }


    @When("I click on button {string}")
    public void iClickOnButton(String btn) {
        getDriver().findElement(By.xpath("//span[contains(text(),' Save')]"));

    }


    @And("I verify current Url as{string}")
    public void iVerifyCurrentUrlAs(String curUrl) {
        String actualUrl=getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(curUrl)).isTrue();
    }
}

