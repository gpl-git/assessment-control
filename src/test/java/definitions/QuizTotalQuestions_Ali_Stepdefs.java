package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class QuizTotalQuestionsStepdefs {


    @Given("I Go to login page")
    public void iGoToLoginPage() {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @And("I sign in with credential email:{string}, password:{string}")
    public void iSignInWithCredentialEmailPassword(String email, String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @And("I create new quiz {string} with {int} {string} questions")
    public void iCreateNewQuizWithQuestions(String quizName, int questionsNumber, String questionType) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]/..")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizName);

        By questionTypeRadioButton = questionType.equalsIgnoreCase("Single-Choice") ? By.xpath("(.//mat-radio-button)[2]") : By.xpath("(.//mat-radio-button)[3]");
        By correctAnswerChoice = questionType.equalsIgnoreCase("Single-Choice") ? By.xpath("(.//mat-radio-button)[4]") : By.xpath("(.//mat-checkbox)[1]");

        for (int i = 0; i < questionsNumber; i++) {
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            WebElement questionPanel = getDriver().findElements(By.xpath("//mat-expansion-panel")).get(i);
            Thread.sleep(300);
            questionPanel.findElement(questionTypeRadioButton).click();
            questionPanel.findElement(By.xpath(".//*[@formcontrolname='question']")).sendKeys("Question number: " + (i + 1));
            questionPanel.findElement(By.xpath("(.//*[@formcontrolname='option'])[1]")).sendKeys("Option number: 1");
            questionPanel.findElement(By.xpath("(.//*[@formcontrolname='option'])[2]")).sendKeys("Option number: 2");
            questionPanel.findElement(correctAnswerChoice).click();
        }
        //getDriver().findElement(By.xpath("//span[contains(text(),'Save')]/..")).click();
    }

    @And("I save the quiz")
    public void iSaveTheQuiz() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizName) {
        if (!getDriver().getCurrentUrl().equals("http://ask-qa.portnov.com/#/quizzes")) {
            getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        } else if (getDriver().getCurrentUrl().equals("http://ask-qa.portnov.com/#/quizzes")) {
            getDriver().navigate().refresh();
        }
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='quizzes']")).getText().contains(quizName));
    }

    @And("I delete the quiz {string}")
    public void iDeleteTheQuiz(String quizName) throws InterruptedException {
        getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> quizzes = getDriver().findElements(By.xpath("//mat-expansion-panel"));
        for (WebElement quiz : quizzes) {
            if (quiz.getText().contains(quizName)) {
                quiz.click();
                Thread.sleep(200);
                quiz.findElement(By.xpath("(.//button)[3]")).click();
                break;
            }
        }
        getDriver().findElement(By.xpath("(//mat-dialog-container//button)[2]")).click();
    }

    @And("I find the quiz {string} and push Edit button")
    public void iFindTheQuizAndPushEditButton(String quizName) {
        getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        List<WebElement> quizzes = getDriver().findElements(By.xpath("//mat-expansion-panel"));
        for (WebElement quiz : quizzes) {
            if (quiz.getText().contains(quizName)) {
                quiz.click();
                quiz.findElement(By.xpath("(.//button)[2]")).click();
                break;
            }
        }
    }

    @And("I add {int} {string} question")
    public void iAddQuestion(int questionsNumber, String questionType) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        By questionTypeRadioButton = questionType.equalsIgnoreCase("Single-Choice") ? By.xpath("(.//mat-radio-button)[2]") : By.xpath("(.//mat-radio-button)[3]");
        By correctAnswerChoice = questionType.equalsIgnoreCase("Single-Choice") ? By.xpath("(.//mat-radio-button)[4]") : By.xpath("(.//mat-checkbox)[1]");
        List<WebElement> questionsList = getDriver().findElements(By.xpath("//mat-expansion-panel"));
        System.out.println(questionsList.size());
        for (int i = questionsList.size(); i < questionsList.size() + questionsNumber; i++) {
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            WebElement questionPanel = getDriver().findElements(By.xpath("//mat-expansion-panel")).get(i);
            questionPanel.click();
            Thread.sleep(300);
            questionPanel.findElement(questionTypeRadioButton).click();
            questionPanel.findElement(By.xpath(".//*[@formcontrolname='question']")).sendKeys("Question number: " + (i + 1));
            questionPanel.findElement(By.xpath("(.//*[@formcontrolname='option'])[1]")).sendKeys("Option number: 1");
            questionPanel.findElement(By.xpath("(.//*[@formcontrolname='option'])[2]")).sendKeys("Option number: 2");
            questionPanel.findElement(correctAnswerChoice).click();
        }
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        Assert.assertTrue(getDriver().getPageSource().contains(errorMessage));
    }

    @And("I create new quiz {string}")
    public void iCreateNewQuiz(String quizName) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]/..")).click();
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizName);
    }

    @And("I delete question number 1")
    public void iDeleteQuestionNumber() {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1:')]/../../..")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1:')]/../../..//span[contains(text(),'Delete Question')]")).click();
        getDriver().findElement(By.xpath("(//mat-dialog-container//button)[2]")).click();
    }
}

