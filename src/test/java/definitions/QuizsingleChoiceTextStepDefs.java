package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.By;


import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class QuizsingleChoiceTextStepDefs {
    String titleGenerator = RandomStringUtils.random(2, 1, 99, false, true);
    String quizTitle = "QuizTitle" + titleGenerator;

    @Given("I navigate to {string} page av")
    public void iNavigateToPageAv(String page) {
        switch (page) {
            case "login": {
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            }
            case "registration": {
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            }
            default: {
                System.out.println("The site " + page + " is not supported");
            }
        }

    }

    @Then("I wait for {int} second av")
    public void iWaitForSecondAv(int sec) throws InterruptedException {
        sleep(sec * 1000);
    }

    @When("I type {string} in the email field av")
    public void iTypeInTheEmailFieldAv(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} in the password field av")
    public void iTypeInThePasswordFieldAv(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);

    }

    @When("I click on the button {string} av")
    public void iClickOnTheButtonAv(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]")).click();
    }


    @And("I verify {string} as current url av")
    public void iVerifyAsCurrentUrlAv(String curUrl) {
        String actUrl = getDriver().getCurrentUrl();
        assertThat(actUrl.contains(curUrl)).isTrue();
    }


    @Then("I click on the {string} av")
    public void iClickOnTheAv(String cli) {
        getDriver().findElement(By.xpath("//h5[text()='" + cli + "']")).click();
    }


    @Then("I type {string} as the quiz title av")
    public void iTypeAsTheQuizTitleAv(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add the question av")
    public void iAddTheQuestionAv() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string} type question av")
    public void iSelectTypeQuestionAv(String typeOfQuestion) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + typeOfQuestion + "')]")).click();
    }

    @When("I type question text as {string} into {string} av")
    public void iTypeQuestionTextAsIntoAv(String qText, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='Question *']")).sendKeys(qText);
    }

    @And("I type {string} as option {string} into the {string} av")
    public void iTypeAsOptionIntoTheAv(String optionText, String optionNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(optionText);

    }


    @Then("I select {string} as the correct option in {string} av")
    public void iSelectAsTheCorrectOptionInAv(String optionNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../../mat-radio-button")).click();

    }


    @Then("quiz {string} should be displayed on the list of quizzes av")
    public void quizShouldBeDisplayedOnTheListOfQuizzesAv(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} from the list of quizzes av")
    public void iDeleteFromTheListOfQuizzesAv(String delTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + delTitle + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + delTitle + "')]/../../..//span[contains(text(), 'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(), 'Delete')]")).click();
        Thread.sleep(2000);
    }

    @When("I create quiz title av")
    public void iCreateQuizTitleAv() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }


    @When("I type {int} characters as question text into {string} av")
    public void iTypeIntCharactersAsQuestionTextIntoStringAv(int num, String qNum) {
        int length = num;
        String questionGenerator = RandomStringUtils.random(length, true, true);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionGenerator);

    }

    @And("I type {int} characters as option {string} into the {string} av")
    public void iTypeIntCharactersAsOptionIntoTheAv(int num, String optionNum, String qNum) {
        int length = num;
        String optionGenerator = RandomStringUtils.random(length, true, true);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(optionGenerator);

    }

    @Then("field required message should be displayed")
    public void fieldRequiredMessageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[contains(text(), ' This field is required')]/../../..//textarea[@placeholder='Question *']")).getText();

    }
}






