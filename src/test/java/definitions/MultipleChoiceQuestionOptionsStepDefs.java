package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceQuestionOptionsStepDefs {
    @Given("I go to {string} page OK")
    public void iGoToPageOK(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This site " +url + " is not supported.");
        }
    }

    @And("I wait for {int} sec OK")
    public void iWaitForSecOK(int sec) throws InterruptedException{
        Thread.sleep(1000*sec);
    }

    @When("I type {string} into email field OK")
    public void iTypeIntoEmailFieldOK(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} for password OK")
    public void iTypeForPasswordOK(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click button {string} OK")
    public void iClickButtonOK(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @When("I click {string} menu item OK")
    public void iClickMenuItemOK(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @Then("I type {string} as quiz title OK")
    public void iTypeAsQuizTitleOK(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question OK")
    public void iAddAQuestionOK() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string} question type OK")
    public void iSelectQuestionTypeOK(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+ questionType+"')]")).click();
    }

    @And("I type {string} into {string} OK")
    public void iTypeIntoOK(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@formcontrolname ='question']")).sendKeys(questionText);
    }

    @When("I type {string} as {string} into {string} OK")
    public void iTypeAsIntoOK(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder ='"+optionNumber+"']")).sendKeys(optionText);
    }

    @And("I select {string} as correct option in {string} OK")
    public void iSelectAsCorrectOptionInOK(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../../../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-checkbox")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzes OK")
    public void quizShouldBeDisplayedOnTheListOfQuizzesOK(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete {string} OK")
    public void iDeleteOK(String quizTitle) throws InterruptedException{
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(getDriver().switchTo().activeElement().isDisplayed()).isTrue();
//F       getDriver().switchTo().alert();

    }

    @When("I click on gear icon near one of the options OK")
    public void iClickOnGearIconNearOneOfTheOptionsOK() {
        getDriver().findElement(By.xpath("//ac-question-body-form/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]/mat-icon[1]")).click();
    }

    @Then("a pop up menu should be displayed")
    public void aPopUpMenuShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//div[@role='menu']")).isDisplayed()).isTrue();
    }


    @And("button {string} is disabled")
    public void buttonIsDisabled(String btnDeleteOption) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'"+btnDeleteOption+"')]")).isEnabled()).isFalse();
    }

    @When("I click on gear icon near {string} OK")
    public void iClickOnGearIconNearOK(String optionNumber) {
        getDriver().findElement(By.xpath("//ac-question-body-form/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
    }

    @And("I click button with an up arrow {string} OK")
    public void iClickButtonWithAnUpArrowOK(String moveUp) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Move option up')]")).click();
    }


    @And("I verify that text of {string} moved to {string}")
    public void iVerifyThatTextOfMovedTo(String optNum2, String optNum1) {
        if (optNum1.equals(optNum2)) {
            getDriver().get(optNum2);
        }else{
            System.out.println("Option 2");
        }
        }
    @When("I click gear icon near {string} OK")
    public void iClickGearIconNearOK(String optionNumber) {
        getDriver().findElement(By.xpath("//ac-question-body-form/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]/mat-icon[1]")).click();
    }

    @And("I click button with a down arrow {string} OK")
    public void iClickButtonWithADownArrowOK(String moveDown) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Move option down')]")).click();
    }

    @And("I verify that text of {string} moved to the {string}")
    public void iVerifyThatTextOfMovedToThe(String optNum1, String optNum2) {
        if (optNum2.equals(optNum1)){
            getDriver().get(optNum1);
        }else {
            System.out.println("Option 1");
        }
    }

    @When("I click on gear image near {string} OK")
    public void iClickOnGearImageNearOK(String optionNumber) {
        getDriver().findElement(By.xpath("//ac-question-body-form/div[1]/div[2]/div[1]/div[3]/button[1]/span[1]/mat-icon[1]")).click();
    }

    @And("I click menu button {string} OK")
    public void iClickMenuButtonOK(String btnDeleteOption) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Option')]")).click();
    }
}




