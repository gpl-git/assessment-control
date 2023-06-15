package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static support.TestContext.getDriver;

public class SctStepdefs {
    @Given("I go to {string} page dp")
    public void iGoToPageDp(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");


    }


    @When("I type {string} in the email field")
    public void iTypeInTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} in the password field dp")
    public void iTypeInThePasswordFieldDp(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @And("I click on {string} button dp")
    public void iClickOnButtonDp(String submit) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I delay for {int} sec dp")
    public void iDelayForSecDp(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);

    }


    @When("I click on {string} dp")
    public void iClickOnDp(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @And("I wait for {int} sec dp")
    public void iWaitForSecDp(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @And("I click on {string}")
    public void iClickOn(String new_Quiz) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @When("I type {string} as quiz title dp")
    public void iTypeAsQuizTitleDp(String quizTital) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTital);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String add) {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I select {string} option dp")
    public void iSelectOptionDp(String queType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Single-Choice')]")).click();
    }





    @And("I type {string} into {string} field of{string}")
    public void iTypeIntoFieldOf(String optText, String optNum, String queNum) {
        getDriver().findElement(By.xpath("//div[@class='mat-radio-container']/../../../../../..//textarea[@placeholder='Option 1*']")).sendKeys(optText);
    }


    @And("I enter {string} in {string} field of {string}")
    public void iEnterInFieldOf(String optText, String optNum, String queNum) {
        getDriver().findElement(By.xpath("//div[@class='mat-radio-container']/../../../../../..//textarea[@placeholder='Option 2*']")).sendKeys(optText);
    }

    @And("I click on {string} butten")
    public void iClickOnButten(String save) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("{string} is dispalyed on the Quizzes list")
    public void isDispalyedOnTheQuizzesList(String quizTital) {
        List <WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),\"Dayena's test quiz\")]"));
        for (WebElement title : titles ) {
            if (title.getText().contains(quizTital)){
                title.isDisplayed();

            }
        }
    }

    @When("I type {int} characters in question field of {string}")
    public void iTypeCharactersInQuestionFieldOf(int num, String queNum) {
        boolean useLetters = true;
        boolean useNumbers = true;

        String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(generatedString);

    }

    @When("I select {string} as a correct answer in {string}")
    public void iSelectAsACorrectAnswerIn(String optNum, String queNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']/../../../../../mat-radio-button[contains(@class,'mat-radio-button')]")).click();
    }

    @Then("Error message of exceeded limit should be displayed")
    public void errorMessageOfExceededLimitShouldBeDisplayed() {
        boolean useLetters = true;
        boolean useNumbers = true;

        String generatedString = RandomStringUtils.random(1001, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(generatedString);
        System.out.println("Error message is not displayed and question text field accepts more than 1000 characters.");


    }

    @When("I click in the text field of {string}")
    public void iClickInTheTextFieldOf(String queNum) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).click();
    }

    @And("I click on option{int} button")
    public void iClickOnOptionButton(int optNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']/../../../../../mat-radio-button[contains(@class,'mat-radio-button')]")).click();
    }

    @Then("error message of required field should be displayed")
    public void errorMessageOfRequiredFieldShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']/../../..//mat-error[contains(text(),'This field is required')]")).isDisplayed();
        System.out.println("Question text field is a mandatory field.");

    }

    @When("I type {string} in the question text field")
    public void iTypeInTheQuestionTextField(String text) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(text);
        System.out.println("Question text field accepts both Alphanumeric and Special characters.");
    }

    @When("I type {string} in the question text field area")
    public void iTypeInTheQuestionTextFieldArea(String text) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(text);
        System.out.println("Question text field accepts only special characters");


    }
}

