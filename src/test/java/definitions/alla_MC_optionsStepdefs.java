package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class alla_MC_optionsStepdefs {
    @Given("I navigate to {string} page A.F.")
    public void iNavigateToPageAF(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @Then("I enter {string} into email field A.F.")
    public void iEnterIntoEmailFieldAF(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} into password field A.F.")
    public void iEnterIntoPasswordFieldAF(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click button {string} A.F.")
    public void iClickButtonAF(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I wait for {int} sec A.F.")
    public void iWaitForSecAF(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I click {string} link A.F.")
    public void iClickLinkAF(String link) {
        getDriver().findElement(By.xpath("//h5[text()='" + link + "']")).click();
    }

    @And("I enter {string} as quiz {string} A.F.")
    public void iEnterAsQuizAF(String text, String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='" + title + "']")).sendKeys(text);
    }

    @And("I click on Add Question A.F.")
    public void iClickOnAddQuestionAF() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question type A.F.")
    public void iSelectQuestionTypeAF(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @Then("error message for {string} and {string} should be displayed A.F.")
    public void errorMessageForAndShouldBeDisplayedAF(String optionNum1,String optionNum2) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + optionNum1 + "')]/../../../..//mat-error")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'" + optionNum2 + "')]/../../../..//mat-error")).isDisplayed()).isTrue();
    }

    //  input 1000 characters
    @When("I type in {string} field positive test")
    public void iTypeInFieldPositiveTest(String optionNum) throws InterruptedException {
        String str = "OptionText";
        String optionText = str.repeat(100);
        getDriver().findElement(By.xpath("//*[@placeholder='" + optionNum + "']")).sendKeys(optionText);
        Thread.sleep(1000);
    }

    //  input 1001 characters
    @Then("I type in {string} field negative test")
    public void iTypeInFieldNegativeTest(String optionNum) throws InterruptedException {
        String str = "OptionText";
        String optionText = str.repeat(100) + '1';
        getDriver().findElement(By.xpath("//*[@placeholder='" + optionNum + "']")).sendKeys(optionText);
        Thread.sleep(1000);
    }

    @And("error message {string} should be displayed A.F.")
    public void errorMessageShouldBeDisplayedAF(String msg) {

    }

    @Then("{string} is displayed")
    public void isDisplayed(String optionNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='" + optionNum + "']")).isDisplayed()).isTrue();
    }

    @When("I enter in {string} whitespaces {string} only")
    public void iEnterInWhitespacesOnly(String optionNum, String whitespaces) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@placeholder='" + optionNum + "']")).sendKeys(whitespaces);
        Thread.sleep(1000);
    }

    @When("I fill out {string} and {string} fields")
    public void iFillOutAndFields(String optionNum1, String optionNum2) {
        getDriver().findElement(By.xpath("//*[@placeholder='" + optionNum1 + "']")).sendKeys(optionNum1);
        getDriver().findElement(By.xpath("//*[@placeholder='" + optionNum2 + "']")).sendKeys(optionNum2);
    }

    @Then("I click on settings in {string}")
    public void iClickOnSettingsIn(String optionNum) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + optionNum + "')]/../../../../../..//*[contains(@class,'icons')]")).click();
    }

    @And("I click on {string}")
    public void iClickOn(String settingsOption) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + settingsOption + "')]")).click();
    }

    @Then("error message is displayed A.F.")
    public void errorMessageIsDisplayedAF() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'correct answer')]")).isDisplayed()).isTrue();
    }

    @When("I choose {string} as a correct answer")
    public void iChooseAsACorrectAnswer(String optionNum) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + optionNum + "')]/../../../../../..//*[contains(@class,'inner')]")).click();
    }

//    @Then("error message is not displayed A.F.")
//    public void errorMessageIsNotDisplayedAF() {
//        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'correct answer')]")).isDisplayed()).isFalse();
//    }

    @When("I add up to {int} options to multiple-choice question A.F.")
    public void iAddUpToOptionsToMultipleChoiceQuestionAF(int num) {
        for(int i=3; i<=num; i++){
            getDriver().findElement(By.xpath("//*[contains(text(),'Add Option')]")).click();
            getDriver().findElement(By.xpath("//*[@placeholder= '"+ "Option " + i + "*"+"']")).sendKeys("Option" + i);
        }
    }

    @And("I delete question A.F.")
    public void iDeleteQuestionAF() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Q1')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Confirmation')]/../..//*[contains(text(),'Delete')]")).click();
    }

    @And("I back to quizzes list A.F.")
    public void iBackToQuizzesListAF() {
        getDriver().findElement(By.xpath("//*[contains(text(),'List')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Confirmation')]/../..//*[contains(text(),'Discard')]")).click();
    }
}