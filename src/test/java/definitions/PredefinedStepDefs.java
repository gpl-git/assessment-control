package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class PredefinedStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This site " + url + "is not supported");

        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into the password field")
    public void iTypeIntoThePasswordField(String pwd) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(pwd);

    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I click on {string} menu")
    public void iClickOnMenu(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//*[text()='add_circle']")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type {string} into {string}")
    public void iTypeInto(String qText, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(qText);
    }

    @When("I type {string} as {string} into {string}")
    public void iTypeAsInto(String optionText, String optionNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(optionText);
    }

    @And("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String qNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../..//mat-radio-button")).click();
    }

    @Then("{string} is displayed on the list of quizzes")
    public void isDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isTrue();

    }

    @And("I delete {string} from the list of quizzes")
    public void iDeleteFromTheListOfQuizzes(String quizTitle) throws InterruptedException {
        List<WebElement> quizzes = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]"));
        for (WebElement quiz : quizzes) {
            quiz.click();
            Thread.sleep(1500);
            getDriver().findElement(
                            By.xpath("//mat-expansion-panel[contains(@class, 'expanded')]//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[contains(text(),'Delete')]"))
                    .click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
            Thread.sleep(1000);
        }
    }
}
