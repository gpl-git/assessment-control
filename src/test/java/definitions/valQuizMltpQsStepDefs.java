package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static support.TestContext.getDriver;

public class valQuizMltpQsStepDefs {

    @Given("I go to the website {string}")
    public void iGoToTheWebsite(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");

    }

    @When("I enter valid {string} into email field")
    public void iEnterValidIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I enter valid {string} into password field")
    public void iEnterValidIntoPasswordField(String pssw) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pssw);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]")).click();
    }

    @Then("I go to {string} page")
    public void iGoToPage(String pageName) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+pageName+"')]")).click();
    }


    @Then("I enter title {string} into quiz field")
    public void iEnterTitleIntoQuizField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }


    @Then("I click button to add a question")
    public void iClickButtonToAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I choose {string} question")
    public void iChooseQuestion(String qType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+qType+"')]")).click();
    }

    @Then("I type question {string} into {string} question field")
    public void iTypeQuestionIntoQuestionField(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @Then("I verify that question {string} has {int} options")
    public void iVerifyThatQuestionHasOptions(String quesNum, int optionNum) {
       for (int i = 1; i < optionNum+1; i++){
           WebElement opt = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quesNum+"')]/../../..//*[@placeholder='Option "+i+"*']"));
           opt.sendKeys("Option"+i);

       }
    }


    @Then("I select first and last correct option from {int} option {string} question")
    public void iSelectFirstAndLastCorrectOptionFromOptionQuestion(int optNum, String questionName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionName+"')]/../../..//*[contains(text(),'Option 1*')]/../../../../../..//*[input]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionName+"')]/../../..//*[contains(text(),'Option "+optNum+"*')]/../../../../../..//*[input]")).click();
    }

    @Then("I click {string} button and add {int} options")
    public void iClickButtonAndAddOptions(String button, int optionNum) {
        for (int i = 1; i < optionNum-1; i++) {
            getDriver().findElement(By.xpath("//span[contains(text(),'" + button + "')]")).click();
        }
    }


    @Then("I verify the error message {string}")
    public void iVerifyTheErrorMessage(String erMsg) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+erMsg+"')]")).isDisplayed();

    }

    @Then("I include Other text area option for this question")
    public void iIncludeOtherTextAreaOptionForThisQuestion() {
        getDriver().findElement(By.xpath("//span[contains(text(),'text area option for this question')]")).click();
    }



    @Then("I verify that the quiz {string} is saved")
    public void iVerifyThatTheQuizIsSaved(String quizTitle) {
        List<WebElement> allQuizzes = getDriver().findElements(By.xpath("//mat-panel-title"));
        for (WebElement quiz : allQuizzes) {
            if (quiz.getText().contains(quizTitle)) {

                WebElement oneQuiz = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]"));
                JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                executor.executeScript("arguments[0].click();", oneQuiz);


            }
        }
    }

    @Then("I click {string} button in quiz {string}")
    public void iClickButtonInQuiz(String button, String quizTitle) {
        List<WebElement> allQuizzes = getDriver().findElements(By.xpath("//mat-panel-title"));
        for (WebElement quiz : allQuizzes) {
            if (quiz.getText().contains(quizTitle)) {
                quiz.click();
            }
        }

        WebElement previewButton = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[text()='"+button+"']"));
        JavascriptExecutor executor1 = (JavascriptExecutor) getDriver();
        executor1.executeScript("arguments[0].click();", previewButton);
    }

    @And("I verify that question {string} is displayed")
    public void iVerifyThatQuestionIsDisplayed(String questionName) {

        String qN = getDriver().findElement(By.xpath("//h3[contains(text(),'"+questionName+"')]")).getText();

        System.out.println(qN);
//        assertThat(qN.contains(questionName)).isTrue();

    }


    @Then("I enter white spaces into {int} default options field of {string}")
    public void iEnterWhiteSpacesIntoDefaultOptionsFieldOf(int optionNum, String quesNum) {
        for (int i = 1; i < optionNum+1; i++){
            WebElement opt = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quesNum+"')]/../../..//*[@placeholder='Option "+i+"*']"));
            opt.sendKeys("");

        }
    }



}



