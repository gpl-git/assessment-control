package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;

public class SCQ_with_options_stepDefs_anitha {

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "login":
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            case "register":
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            case "forgot_password":
                getDriver().get("http://ask-qa.portnov.com/#/forgot-password");
                break;
        }
    }

    @When("I enter the teachers email {string} into email field")
    public void iEnterTheTeachersEmailIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter the password {string} into password field")
    public void iEnterThePasswordIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @And("I wait for {int} sec for the presence of all the elements on the page")
    public void iWaitForSecForThePresenceOfAllTheElementsOnThePage(long time) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    @Then("I should see the text {string} present in the home page")
    public void iShouldSeeTheTextPresentInTheHomePage(String txtPresence) {
        getDriver().findElement(By.xpath("//p[contains(text(),'" + txtPresence + "')]")).isDisplayed();
    }


    @And("I click the {string} menu item from the home page")
    public void iClickTheMenuItemFromTheHomePage(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @And("I click {string} button under the list of quizzes section")
    public void iClickButtonUnderTheListOfQuizzesSection(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I type {string} in the quiz title field")
    public void iTypeInTheQuizTitleField(String quizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question by clicking the button Add question")
    public void iAddAQuestionByClickingTheButtonAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select the question type as {string}")
    public void iSelectTheQuestionTypeAs(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type the question as {string} into question field of {string}")
    public void iTypeTheQuestionAsIntoQuestionFieldOf(String questText, String questNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@formcontrolname='question']")).sendKeys(questText);
    }

    @And("I type {string} into the {string} of {string}")
    public void iTypeIntoTheOf(String optText, String optNum, String questNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='" + optNum + "*']")).sendKeys(optText);
    }


    @And("I select the {string} from the list of options for question {string}")
    public void iSelectTheFromTheListOfOptionsForQuestion(String optionNumber, String questNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questNum + "')]/following::textarea[@placeholder='" + optionNumber + "*']/preceding::mat-radio-button[1]")).click();
    }

    @Then("I should see the quiz name {string} in the list of quizzes section")
    public void iShouldSeeTheQuizNameInTheListOfQuizzesSection(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-panel-title"));
        for (WebElement title : titles) {
            if (title.getText().contains(quizTitle)) {
                title.isDisplayed();
                title.click();
            }
        }
    }

//    @And("I delete the quiz name {string} from the list of quizzes")
//    public void iDeleteTheQuizNameFromTheListOfQuizzes(String quizTitle) {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[text()='Delete']")).click();
//        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='Delete']")).click();
//    }


    @Then("I should see an error message on the snack-bar")
    public void iShouldSeeAnErrorMessageOnTheSnackBar() {
        getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(),'Quiz is not completed. Check highlighted')]")).isDisplayed();
    }

    @And("I should an error message on the {string} field")
    public void iShouldAnErrorMessageOnTheField(String option) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + option + "*']/following::mat-error[contains(text(),'This field is required')]")).isDisplayed();
    }

    @And("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMsg) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + errorMsg + "')]")).isDisplayed();
    }

    @And("I click the {string} from the list of quizzes section")
    public void iClickTheFromTheListOfQuizzesSection(String quizTitle) throws InterruptedException {
        WebElement title = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", title);
        Thread.sleep(500);
        title.click();
    }

    @And("I {string} the quiz name {string} from the list of quizzes")
    public void iTheQuizNameFromTheListOfQuizzes(String btnName, String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[text()='"+btnName+"']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='"+btnName+"']")).click();
//        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }


    @And("I click {string} in the confirmation window")
    public void iClickInTheConfirmationWindow(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @And("I {string} the quiz name {string} from the list of quizzes section")
    public void iTheQuizNameFromTheListOfQuizzesSection(String btnName, String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/following::span[text()='"+btnName+"']")).click();
    }

//    @And("I {string} the quiz name {string} from the list of quizzes section")
//    public void iTheQuizNameFromTheListOfQuizzesSection(String arg0, String arg1) {
//        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='"+btnName+"']")).click();
//    }
}
