package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTQLutkovStepDefs {

    public static String quizTitleTimeStamp; // global var
    public static int questionNumbers; // global var

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        if(url.equals("Sign In")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("Unsupported site " + url);
        }
    }

    @When("I {string} with email: {string} and password: {string}")
    public void iWithEmailAndPassword(String action, String email, String pswd) {
        if(action.equals("Sign In")){
            new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='controls']/descendant::span[contains(text(),'" + action + "')]")));

            WebElement emailElement = getDriver().findElement(By.xpath("//input[@formcontrolname='email']"));
            WebElement pswdElement = getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
            WebElement btnElement = getDriver().findElement(By.xpath("//div[@class='controls']/descendant::span[contains(text(),'" + action + "')]"));

            emailElement.sendKeys(email);
            pswdElement.sendKeys(pswd);
            btnElement.click();
        }
        else {
            Assert.fail("Please type 'Sign In'.");
        }
    }

    @Then("I check user role as {string}")
    public void iCheckUserRoleAs(String userRole) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='info']")));

        WebElement userInfo = getDriver().findElement(By.xpath("//div[@class='info']"));

        String userInfoStr = userInfo.getText();
        boolean userRoleBoolean = userInfoStr.toLowerCase().contains(userRole.toLowerCase());
        Assert.assertEquals(userRoleBoolean, true, "Only 'Teacher' user role is good for this test scenario.");
    }

    @Then("I check that the {string} page is open")
    public void iCheckThatThePageIsOpen(String page) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.urlContains(page.toLowerCase()));

        String urlPage = getDriver().getCurrentUrl();
        assertThat(urlPage.toLowerCase().contains(page.toLowerCase())).isTrue();
    }

    @Then("I check that the {string} is displayed")
    public void iCheckThatTheIsDisplayed(String text) {
        new WebDriverWait(getDriver(), 30, 200).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-card/child::*[contains(text(),'" + text + "')]")));

        List<WebElement> textList = getDriver().findElements(By.xpath("//mat-card/child::*[contains(text(),'" + text + "')]"));
        assertThat(textList).hasSizeGreaterThan(0);
    }

    @Then("I check that the {string} is visible")
    public void iCheckThatTheIsVisible(String text) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ac-quiz-builder-page/descendant::*[contains(text(),'" + text + "')]")));
        List<WebElement> textList = getDriver().findElements(By.xpath("//ac-quiz-builder-page/descendant::*[contains(text(),'" + text + "')]"));
        assertThat(textList).hasSizeGreaterThan(0);
    }

    @When("I enter {string} with timestamp as a quiz title")
    public void iEnterWithTimestampAsQuizTitle(String title) {
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
        String titleTimeStamp = title +"_" + timeStamp;
        quizTitleTimeStamp = titleTimeStamp;

        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(titleTimeStamp);
    }

    @When("I enter {string} as a question title")
    public void iEnterAsAQuestionTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(title);
    }

    @When("I create {int} question as a {string} question type with a question title: {string} and with an answer for Option1: {string}, answer for Option2: {string}")
    public void iCreateQuestionAsAQuestionTypeWithAQuestionTitleAndWithAnAnswerForOptionAnswerForOption(int questionsNumber, String type, String title, String answerOption1, String answerOption2) throws InterruptedException {
        questionNumbers = questionsNumber;
        int secSleep = 1;
        switch (type){
            case "Textual": {
                if (questionsNumber == 1) {
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[contains(text(),'" + type + "')]")).click();
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(title);
                    Thread.sleep(secSleep * 1000);
                } else if (questionsNumber > 1) {
                    for (int i = 1; i <= questionsNumber; i++) {
                        if (i < questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
                            Thread.sleep(secSleep * 1000);
                        } else if (i == questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                        }
                    }
                }
            }
                break;
            case "Single":{
                if(questionsNumber == 1) {
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[contains(text(),'" + type + "')]")).click();
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(title);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys(answerOption1);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys(answerOption2);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
                    Thread.sleep(secSleep * 1000);
                } else if(questionsNumber > 1){
                    for (int i = 1; i <= questionsNumber; i++){
                        if (i < questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']")).sendKeys(answerOption1 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']")).sendKeys(answerOption2 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
                            Thread.sleep(secSleep * 1000);
                        }
                        else if (i == questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']")).sendKeys(answerOption1 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']")).sendKeys(answerOption2 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
                            Thread.sleep(secSleep * 1000);
                        }
                    }
                }
            }
                break;
            case "Multiple":{
                if(questionsNumber == 1) {
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[contains(text(),'" + type + "')]")).click();
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(title);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys(answerOption1);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys(answerOption2);
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
                    Thread.sleep(secSleep * 1000);
                    getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../../descendant::*[@placeholder='Option 2*']/../../../../../mat-checkbox")).click();
                    Thread.sleep(secSleep * 1000);
                } else if(questionsNumber > 1){
                    for (int i = 1; i <= questionsNumber; i++){
                        if (i < questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']")).sendKeys(answerOption1 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']")).sendKeys(answerOption2 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']/../../../../../mat-checkbox")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
                            Thread.sleep(secSleep * 1000);
                        }
                        else if (i == questionsNumber) {
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[contains(text(),'" + type + "')]")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@formcontrolname='question']")).sendKeys(title + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']")).sendKeys(answerOption1 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']")).sendKeys(answerOption2 + i);
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
                            Thread.sleep(secSleep * 1000);
                            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../../descendant::*[@placeholder='Option 2*']/../../../../../mat-checkbox")).click();
                            Thread.sleep(secSleep * 1000);
                        }
                    }
                }
            }
                break;
            default:{
                Assert.fail("Please, type one of the following type of questions: 'Textual' or 'Single' or 'Multiple'. ");
            }
        }
    }

    @Then("I check that the created quiz with timestamp is visible in the List of Quizzes")
    public void iCheckThatTheCreatedQuizWithTimestampIsVisibleInTheListOfQuizzes() {
        String titleTimeStamp = quizTitleTimeStamp;
        List<WebElement> titleList = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]"));
        assertThat(titleList).hasSizeGreaterThan(0);
    }

    @When("I expand my quiz")
    public void iExpandMyQuiz() {
        String titleTimeStamp = quizTitleTimeStamp;
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]")));
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]")).click();
    }

    @Then("I compare the number of Total Questions to the number of questions we have created")
    public void iCompareTheNumberOfTotalQuestionsToTheNumberOfQuestionsWeHaveCreated() {
        String titleTimeStamp = quizTitleTimeStamp;
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]/../../../descendant::td[contains(text(),'Total Questions:')]/following-sibling::*")));

        String totalNumberStr = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]/../../../descendant::td[contains(text(),'Total Questions:')]/following-sibling::*")).getText();
        int totalNumberInt = Integer.parseInt(totalNumberStr);
        Assert.assertEquals(totalNumberInt, questionNumbers, "Number of questions added to the quiz NOT equals the number of total questions displayed in the expansion panel. ");
    }

    @When("I click {string} button on my quiz")
    public void iClickButtonOnMyQuiz(String text) throws InterruptedException {
        String titleTimeStamp = quizTitleTimeStamp;
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + titleTimeStamp + "')]/../../../descendant::*[contains(text(),'" + text + "')]")).click();

        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mat-dialog-actions']/descendant::*[contains(text(),'" + text + "')]")));
        getDriver().findElement(By.xpath("//*[@class='mat-dialog-actions']/descendant::*[contains(text(),'" + text + "')]")).click();
        Thread.sleep(2 * 1000);
    }

    @Then("I check that it is not possible to create more than {int} questions in one quiz as per current requirements")
    public void iCheckThatItIsNotPossibleToCreateMoreThanQuestionsInOneQuizAsPerCurrentRequirements(int maxQuestionNumber) {
        int currentQuestionNumber = questionNumbers;
        boolean checkRequirements = currentQuestionNumber <= maxQuestionNumber;
        Assert.assertEquals(checkRequirements, true, "User can add and save more than 50 questions to the quiz. Please, verify the requirements and report the bug. ");
    }
}