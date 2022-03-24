package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextStepdefs {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
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
    public void iEnterAsPassword(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @When("I click on {string} menu item")
    public void iClickOnMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }


    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add question")
    public void iAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Textual')]")).click();
    }

    @When("I  type {string} into {string}")
    public void iTypeInto(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Test Quiz - Igor')]")).isDisplayed()).isTrue();

    }

    @And("I delete {string}")
    public void iDelete(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Test Quiz - Igor')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Test Quiz - Igor')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
