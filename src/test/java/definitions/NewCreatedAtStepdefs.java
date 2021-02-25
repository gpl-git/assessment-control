package definitions;

import com.google.inject.internal.Errors;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestContext;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

import static support.TestContext.getDriver;

public class NewCreatedAtStepdefs {
    private String saveName;
    private Date dateTime;
    private Object DateTimeFormatter;

    @Given("I go to {string}")
    public void iGoTo(String url) {
        TestContext.getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I type {string} email")
    public void iTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} in the password field")
    public void iTypeInThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @And("I wait few seconds")
    public void iWaitFewSeconds(String sec) throws InterruptedException {
        Thread.sleep(1000);

    }

    @Then("I click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I click on {string} btn")
    public void iClickOnBtn(String quizName) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @And("I wait {int} seconds")
    public void iWaitSeconds(int sec) throws InterruptedException {
        Thread.sleep(1000);

    }

    @Then("I click on {string}")
    public void iClickOn(String create) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @Then("I type into Title field {string}")    public void iTypeIntoTitleField(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I wait {int} second")
    public void iWaitSecond(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @Then("I add a question in QUIZ#{int}")
    public void iAddAQuestionInQUIZ(int question) {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I click on radio button {string}")
    public void iClickOnRatioButton(String textualType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Textual')]")).click();
    }

    @And("I type {string} into {string} field")
    public void iTypeIntoField(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @Then("on the right side I click on {string}")
    public void onTheRightSideIClickOn(String sName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

    }

    @Then("I click on {string} in quiz list")
    public void iClickOnInQuizList(String Qlist) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'QUIZ #20')]")).click();
    }

    @Then("title {string}  is displayed on the list of quizzes")
    public void titleIsDisplayedOnTheListOfQuizzes(String title) {
        List<WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));

        for (WebElement element : titles) {
            if (element.getText().contains(title)) {
                element.isDisplayed();
            }
        }
    }

    @Then("title {string} should contain text {string}")
    public void titleShouldContainText(String Qnum, String Qtext) {
        Date dateOne = new Date();
        System.out.println(Qtext+ dateOne);
        dateOne.setTime(1000);
    }
}

