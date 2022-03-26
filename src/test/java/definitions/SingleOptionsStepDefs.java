package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleOptionsStepDefs {
    @Given("I go to {string} page MB")
    public void iGoToPageMB(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @And("I wait for {int} sec MB")
    public void iWaitForSecMB(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I type {string} into email field MB")
    public void iTypeIntoEmailFieldMB(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} as  password MB")
    public void iEnterAsPasswordMB(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @When("I click button {string} MB")
    public void iClickButtonMB(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I click on {string} menu item MB")
    public void iClickOnMenuItemMB(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I type {string} as quiz title MB")
    public void iTypeAsQuizTitleMB(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question MB")
    public void iAddAQuestionMB() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question type MB")
    public void iSelectQuestionTypeMB(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type {string} into {string} MB")
    public void iTypeIntoMB(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type {string} as {string} into {string} MB")
    public void iTypeAsIntoMB(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string} MB")
    public void iSelectAsCorrectOptionInMB(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzes MB")
    public void quizShouldBeDisplayedOnTheListOfQuizzesMB(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} MB")
    public void iDeleteMB(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("error message {string} should be displayed MB")
    public void errorMessageShouldBeDisplayedMB(String errormessage) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("element {string} should be disabled MB")
    public void elementShouldBeDisabledMB(String btnName) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).isEnabled()).isFalse();
    }

    @And("I click icon {string} MB")
    public void iClickIconMB(String settings) {
        getDriver().findElement(By.xpath("(//span[@class='mat-button-wrapper'])[1]")).click();
    }


    @And("I add up to {int} options to{string} MB")
    public void iAddUpToOptionsToMB(int optionNum, String questionNum) {
        for (int i = 3; i <=optionNum; i++){
            getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNum+"')]/../../..//*[contains(text(),'Add Option')]")).click();
            String xpath = "//*[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='Option "+i+ "*']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Option " + i);
        }
    }




//    @When("I enter {int} alphanumeric characters into {string} MB")
//    public void iEnterAlphanumericCharactersIntoMB(int number, String optionNumber) {
//        int length = number;
//        boolean useLetters = true;
//        boolean useNumbers = true;
//        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
//        System.out.println(generatedString);
//        getDriver().findElement(By.xpath("//*[contains(text(),'"+optionNumber+"')]/../../..//*[contains(text(),'Add Option')]")).sendKeys(generatedString);
//    }

    @When("I enter {int} alphanumeric characters as {string} into {string} MB")
    public void iEnterAlphanumericCharactersAsIntoMB(int number, String optionNumber, String questionNumber) {
        int length = number;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']")).sendKeys(generatedString);
    }
}
