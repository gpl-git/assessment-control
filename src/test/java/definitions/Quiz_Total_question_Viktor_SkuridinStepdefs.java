package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Quiz_Total_question_Viktor_SkuridinStepdefs {


    @When("I type {string} into email VS")
    public void iTypeIntoEmail(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password VS")
    public void iTypeIntoPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I am wait for {int} sec VS")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @And("I click on {string} menu item VS")
    public void iClickMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I click on {string} button VS")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I type {string} in quiz title VS")
    public void iTypeAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I click add a question VS")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} type question VS")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I am type {string} into question field of {string} VS")
    public void iTypeIntoQuestionFieldOf(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @When("I am type {string} into {string} option field of {string} VS")
    public void iTypeIntoOptionFieldOf(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "*']")).sendKeys(optionText);
    }

    @When("I am select {string} as a correct option in {string} VS")
    public void iSelectAsACorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "*']/../../../../..//mat-radio-button")).click();
    }

    @Then("{string} is displayed on the list of quizzes page VS")
    public void isDisplayedOnTheListOfQuizzes(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title : titles) {
            if (title.getText().contains(quizTitle)) {
                title.isDisplayed();
            }
        }
    }

    @Then("I click on {string} VS")
    public void iClickOn(String titlequiz) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + titlequiz + "')]")).click();
    }

    @And("I am delete {string} from the list of quizzes VS")
    public void iDeleteFromTheListOfQuizzes(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @When("I add {int} Textual questions VS")
    public void iAddTextualQuestions(int num) throws InterruptedException {
        for (int i = 1; i <= num; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(150);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'Textual')]")).click();
            String xpath = "//*[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Question *']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Question " + i);
        }
    }

    @And("I open quizzes VS")
    public void iOpenQuizzes() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[text() = 'Quizzes']")).click();
        Thread.sleep(100);
    }

    @And("I verify that {string} total question is {string} \\(same as it was created) VS")
    public void iVerifyThatTotalQuestionIsSameAsItWasCreated(String quizname, String questioncount) {
        String total = (getDriver().findElement(By.xpath("((//*[contains(text(),'" + quizname + "')])[1]/../../..//td[contains(text(),'" + questioncount + "')])[1]")).getText());
        assertThat(total.equals(questioncount)).isTrue();
    }
//        if (total.equals(questioncount)) {
//            System.out.println("Question count is correct");
//        }else {
//            System.out.println("Question count is not correct");
//        }


    @Then("error message {string} is displayed VS")
    public void errorMessageIsDisplayed(String message) {
        WebElement errmessage = getDriver().findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
        assertThat(errmessage.isDisplayed()).isTrue();
    }
//        List<WebElement> elements = getDriver().findElements(By.xpath("//*[contains(text(),'" + message + "')]"));
//        if (elements.isEmpty()) {
//            System.out.println("Error message '" + message + "' is not displayed.");
//        } else {
//            System.out.println("Error message '" + message + "' is displayed.");
//        }


    @Then("error message {string} must displayed")
    public void errorMessageQuizIsNotCompletedCheckHighlightedWithAreasMustDisplayed(String errormessage) {
//        String message = (getDriver().findElement(By.xpath("//*[contains(text(),'" + errormessage + "')]")).getText());
//        assertThat(message.equals(errormessage)).isTrue();

        WebElement message1 = getDriver().findElement(By.xpath("//*[contains(text(),'" + errormessage + "')]"));
        assertThat(message1.isDisplayed()).isTrue();
    }

    @Given("I navigate to {string} page VS")
    public void iNavigateToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site " + url + " is not supported.");
        }
    }
}



