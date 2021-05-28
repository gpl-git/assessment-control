package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LilitQuizStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site " + url + " is not supported");
        }

    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }


    @And("I click on {string} link")
    public void iClickOnLink(String link) {
        getDriver().findElement(By.xpath("//h5[text()='" + link + "']")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    @Given("I add text {string} as title of the quiz")
    public void iAddTextAsTitleOfTheQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I click add question button")
    public void iClickAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I select {string} question option")
    public void iSelectQuestionOption(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Textual')]")).click();
    }

    @When("I type {string} as question {string} text field {string}")
    public void iTypeAsQuestionTextField(String text, String questionNumber, String optionNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionNumber + "')]/../../..//*[@placeholder='" + optionNumber + "']")).sendKeys(text);

    }

    @Then("the quiz title {string} should be displayed in the list of quizzes")
    public void theQuizTitleShouldBeDisplayedInTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).isDisplayed()).isTrue();

    }

    @Given("I add text with {string} as title of the quiz")
    public void iAddTextWithAsTitleOfTheQuiz(String title) {
        int length = 1000;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        title = generatedString;

        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @Given("I type {string} in the field Title of the Quiz")
    public void iTypeInTheFieldTitleOfTheQuiz(String title) {
        int length = 1001;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        title = generatedString;

        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);

    }

    @Given("I type {string} as title of the quiz")
    public void iTypeAsTitleOfTheQuiz(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);

    }

    @Then("quiz {string} should be displayed on the list of quizzes")
    public void quizShouldBeDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '    Test     Leading and      trailing space')]")).isDisplayed()).isTrue();

    }

    @And("title of the quiz {string} should not have leading spaces")
    public void titleOfTheQuizShouldNotHaveLeadingSpaces(String myTitle) {
        if (myTitle.equalsIgnoreCase("Test Leading and trailing space")) {
            getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        } else {
            System.out.println("Site " + myTitle + " is not supported");


        }
    }

    @And("I delete letter {string} from title")
    public void iDeleteLetterFromTitle(String delete) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.BACK_SPACE);
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String alert) {
        String actualAlert = getDriver().findElement(By.xpath("//mat-error[contains(@class, 'ng-star-inserted')]")).getText();
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(@class, 'ng-star-inserted')]")).isDisplayed()).isTrue();

    }


    @Then("next page has error message {string}")
    public void nextPageHasErrorMessage(String error) {
        String actualMessage = getDriver().findElement(By.xpath("//mat-error[contains(@class, 'ng-star-inserted')]")).getText();
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(@class, 'ng-star-inserted')]")).isDisplayed()).isTrue();
    }
}





