package definitions;

import com.sun.jdi.IntegerValue;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.dependency.difflib.StringUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static support.TestContext.getDriver;

public class tim_Quiz_Total_Questions {
    @Given("I go to {string} page TN")
    public void iGoToPageTN(String URL) {
        if (URL.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (URL.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else System.out.println("Please use 'login' or 'registration' to navigate to corresponding page");
    }

    @When("I enter {string} into Email text field **TN")
    public void iEnterIntoEmailTextFieldTN(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter {string} into Password text field **TN")
    public void iEnterIntoPasswordTextFieldTN(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @Then("I click on button with text {string} **TN")
    public void iClickOnButtonWithTextTN(String buttonText) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + buttonText + "')]/..")).click();
    }

    @Then("I click on menu item with text {string} from left-side menu **TN")
    public void iClickOnMenuItemWithTextFromLeftSideMenu(String menuText) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuText + "')]/..")).click();
    }

    @Then("I enter Quiz title as {string} into quiz title text field **TN")
    public void iEnterQuizTitleAsIntoQuizTitleTextFieldTN(String qTitle) {
        getDriver().findElement(By.xpath("//*[@placeholder='Title Of The Quiz *']")).sendKeys(qTitle);
    }

    @And("I click on Add Question **TN")
    public void iClickOnAddQuestion() {
        getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']/../..")).click();
    }

    @And("Error message should be displayed **TN")
    public void errorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Quiz is not completed')]")).isDisplayed()).isTrue();
    }

    @And("I do nothing for {int} sec **TN")
    public void iDoNothingForSecTN(int sec) {
        getDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    @And("hold for {int} sec **TN")
    public void holdForSecTN(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000L);
    }

    @Then("I click on {string}question type **TN")
    public void iClickOnQuestionTypeTN(String qType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + qType + "')]/..")).click();
    }

    @And("I enter question {string} into question text field")
    public void iEnterQuestionIntoQuestionTextField(String question) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(question);
    }

    @And("I should see quiz with name {string} in the list of quizzes")
    public void iShouldSeeQuizWithNameInTheListOfQuizzes(String qName) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qName + "')]")).isDisplayed()).isTrue();
    }

    @Then("I delete created quiz {string} **TN")
    public void iDeleteCreatedQuizTN(String qName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qName + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qName + "')]/..//..//..//*[contains(text(),'Delete')]/..")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation/..//span[contains(text(),'Delete')]/..")).click();
    }

    @And("I create {int} Textual questions {string} **TN")
    public void iCreateTextualQuestions(int totalQuestions, String textQuestion) throws InterruptedException {

        for (int questionNum = 1; questionNum <= totalQuestions; questionNum++) {
            getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']/../..")).click();
            Thread.sleep(200L);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//div[contains(text(),'Textual')]/..")).click();
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(textQuestion);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    @And("I print total questions number **TN")
    public void iPrintTotalQuestionsNumber() {

        // I create a string with the title of the very last question
        String str = getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//mat-panel-title")).getText();
        str = str.replace("Q", ""); //I remove "Q" from my string
        str = str.substring(0, str.indexOf(":") + 1); //I locate index of ":" and generate a substring of everything between "0 index" and ":"
        str = str.replace(":", ""); //I remove ":" and leave only last Question number

        System.out.println("The TOTAL number of questions in the quiz is: " + str);
    }


    @And("I create {int} Single Choice questions {string} with Option {int} as {string}; Option {int} as {string}. And correct answer is Option {int} **TN")
    public void iCreateSingleChoiceQuestionsWithOptionAsOptionAsAndCorrectAnswerIsOptionTN(int totalQuestions, String scQuestion, int opt1, String answer1, int opt2, String answer2, int correctAnswer) throws InterruptedException {

        // I create a string with the title of the very last question to find start point for the loop
        String str = getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//mat-panel-title")).getText();
        str = str.replace("Q", ""); //I remove "Q" from my string
        str = str.substring(0, str.indexOf(":") + 1); //I locate index of ":" and generate a substring of everything between "0 index" and ":"
        str = str.replace(":", ""); //I remove ":" and leave only last Question number

        int startQuestion = Integer.parseInt(str); //I transform string data to integer
        System.out.println("The first Single-Choice question number was: " + (startQuestion + 1));

        startQuestion = startQuestion + 1;

        for (int i = startQuestion; i <= totalQuestions + startQuestion - 1; i++) {
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']/../..")).click();
            Thread.sleep(200L);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//div[contains(text(),'Single-Choice')]/..")).click();
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(scQuestion);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + opt1 + "" + '*' + "']")).sendKeys(answer1);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + opt2 + "" + '*' + "']")).sendKeys(answer2);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + correctAnswer + "" + '*' + "']/../../../../../mat-radio-button/label")).click();
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }
    }

    @And("I create {int} Multiple Choice questions {string} with Option {int} as {string}; Option {int} as {string}; Option {int} as {string}. And correct answer is Option {int} **TN")
    public void iCreateMultipleChoiceQuestionsWithOptionAsOptionAsOptionAsAndCorrectAnswerIsOptionTN(int totalQuestions, String mchQuestion, int opt1, String variant1, int opt2, String variant2, int opt3, String variant3, int correctVariant) throws InterruptedException {

        // I create a string with the title of the very last question
        String str = getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//mat-panel-title")).getText();
        str = str.replace("Q", ""); //I remove "Q" from my string
        str = str.substring(0, str.indexOf(":") + 1); //I locate index of ":" and generate a substring of everything between "0 index" and ":"
        str = str.replace(":", ""); //I remove ":" and leave only last Question number

        int startQuestion = Integer.parseInt(str); //I convert string data value to integer
        System.out.println("The first Multi-Choice question number is: " + (startQuestion + 1));

        startQuestion = startQuestion + 1;

        for (int i = startQuestion; i <= totalQuestions + startQuestion - 1; i++) {
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']/../..")).click();
            Thread.sleep(200L);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//div[contains(text(),'Multiple-Choice')]/..")).click();
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(mchQuestion);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + opt1 + "" + '*' + "']")).sendKeys(variant1);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + opt2 + "" + '*' + "']")).sendKeys(variant2);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//*[contains(text(),'Add Option')]")).click();
            Thread.sleep(200L);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + opt3 + "" + '*' + "']")).sendKeys(variant3);
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']/mat-expansion-panel[last()]//textarea[@placeholder='Option " + correctVariant + "" + '*' + "']/..//..//..//..//../mat-checkbox")).click();
        }
    }

    @Then("I save my quiz **TN")
    public void iSaveMyQuizTN() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'Save')]/..")).click();
        Thread.sleep(3500L);
    }

}


























