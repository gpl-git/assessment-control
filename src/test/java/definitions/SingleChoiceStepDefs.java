package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceStepDefs {
    @Given("I go to {string} page rv")
    public void iGoToPageRv(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This sie " + url + " is not supported.");
        }
    }

    @And("I wait for {int} sec rv")
    public void iWaitForSecRv(int sec) throws InterruptedException {
        Thread.sleep(1000 *sec);
    }

    @When("I type {string} into email field rv")
    public void iTypeIntoEmailFieldRv(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} as password rv")
    public void iEnterAsPasswordRv(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click button {string} rv")
    public void iClickButtonRv(String btnSignIn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnSignIn + "')]")).click();
    }


    @When("I type {string} as quiz title rv")
    public void iTypeAsQuizTitleRv(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question rv")
    public void iAddAQuestionRv() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question type rv")
    public void iSelectQuestionTypeRv(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type {string} into {string} rv")
    public void iTypeIntoRv(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@formcontrolname ='question']")).sendKeys(questionText);
    }

    @When("I type {string} as {string} into {string} rv")
    public void iTypeAsIntoRv(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder ='" + optionNumber + "']")).sendKeys(optionText);
    }

    @And("I select {string} as correct option in {string} rv")
    public void iSelectAsCorrectOptionInRv(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder ='" + optionNumber + "']/../../../../../mat-radio-button")).click();
    }

    @When("I click {string} menu item rv")
    public void iClickMenuItemRv(String menuItems) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItems + "')]")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzes rv")
    public void quizShouldBeDisplayedOnTheListOfQuizzesRv(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" +quizTitle+ "')]")).isDisplayed()).isTrue();
    }


    @Then("I delete {string} rv")
    public void iDeleteRv(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @Then("I press on Add Option")
    public void iPressOnAddOption() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
    }


    @Then("error message {string} is displayed rv")
    public void errorMessageIsDisplayedRv(String errorMessageCorrectAnswer) {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'"+errorMessageCorrectAnswer+"')]")).isDisplayed()).isTrue();
    }

    @Then("errors message {string} should be displayed rv")
    public void errorsMessageShouldBeDisplayedRv(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+errorMessage+"')]")).isDisplayed()).isTrue();
    }


    @Then("I click on settings icon {string} rv")
    public void iClickOnSettingsIconRv(String optionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../..//mat-icon[contains(text(),'settings')]")).click();
    }

    @And("I delete Option rv")
    public void iDeleteOptionRv() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]")).click();
    }


    @And("I move Option Up rv")
    public void iMoveOptionUpRv() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Move option up')]")).click();
    }

    @When("I enter {int} alphanumeric characters as {string} into {string} rv")
    public void iEnterAlphanumericCharactersAsIntoRv(int numOfCharacters, String optionNum, String questionNum) {
        int lenght = numOfCharacters;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(lenght, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(generatedString);
    }

    @When("I add up to {int} options in {string}")
    public void iAddUpToOptionsIn(int num, String questionNum) {
        String option = "Option ";
        for (int i=3; i <= num; i++){
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
            String xpath = "//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+option + i+ "*']";
            getDriver().findElement(By.xpath(xpath)).sendKeys(option + i);
        }
    }


    @And("I preview quiz {string} rv")
    public void iPreviewQuizRv(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Preview')]")).click();
        getDriver().findElement(By.xpath("//div[@class='controls']//span[contains(text(),'Close')]")).click();
        Thread.sleep(1000);
    }

    @Then("I verify that the number of options equals {int}")
    public void iVerifyThatTheNumberOfOptionsEquals(int options) {
       ArrayList<WebElement> optionsList = new ArrayList<>();
        List<WebElement> listOptions = getDriver().findElements(By.xpath("//textarea[@formcontrolname='option']"));
        optionsList=new ArrayList<WebElement>(getDriver().findElements(By.xpath("//textarea[@formcontrolname='option']")));
        int numOptions = optionsList.size();
        System.out.println(numOptions);
        assertThat(numOptions == options).isTrue();
    }


    @And("button Delete Option is disabled rv")
    public void buttonDeleteOptionIsDisabledRv() {
       getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='Option 2*']/../../../../..//mat-icon")).click();
    }
}

