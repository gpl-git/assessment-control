package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceQuestionTextStepDefs {
    @Given("I navigate to the {string} page")
    public void iNavigateToThePage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("The site " + url + " is not supported");
        }
    }

    @When("I type {string} into the email field")
    public void iTypeIntoTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into the password field")
    public void iTypeIntoThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);

    }


    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]")).click();
    }

    @And("I click on the {string} link")
    public void iClickOnTheLink(String link) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + link + "')]")).click();
    }


    @And("I type {string} as my quiz title")
    public void iTypeAsMyQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }


    @When("I add the question")
    public void iAddTheQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select the {string} question type")
    public void iSelectTheQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type {string} into the {string}")
    public void iTypeIntoThe(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @When("I type {string} as {string} into the {string}")
    public void iTypeAsIntoThe(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']")).sendKeys(optionText);
    }


    @And("I select {string} as correct option in the {string}")
    public void iSelectAsCorrectOptionInThe(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']/../../../../../mat-checkbox")).click();
    }

    @Then("the quiz {string} should be displayed on the list of quizzes")
    public void theQuizShouldBeDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).isDisplayed()).isTrue();
    }

    @Then("I delete {string} from list of quizzes")
    public void iDeleteFromListOfQuizzes(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(), 'Quiz is not completed.')]")).isDisplayed());
    }

    @When("I type in question field more than max characters")
    public void iTypeInQuestionFieldMoreThanMaxCharacters() {
        char[] arr = new char[1001];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = 'a';
        }
        String chars = new String(arr);
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(chars);
    }

    @When("I type in the first option more than max characters")
    public void iTypeInTheFirstOptionMoreThanMaxCharacters() {
    char[] arr = new char[1001];
    for (int i=0; i<arr.length;i++)
    {
        arr[i]='b';
    }
    String chars = new String(arr);
    getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(chars);

    }

    @When("I type in the second option more than characters")
    public void iTypeInTheSecondOptionMoreThanCharacters() {
        char[] arr=new char[1001];
        for (int i=0; i< arr.length; i++)
        {
            arr[i]='c';
        }
        String chars = new String(arr);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(chars);

    }


    @When("I type in question field max characters")
    public void iTypeInQuestionFieldMaxCharacters() {
        char[] arr = new char[1000];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = 'A';
        }
        String chars = new String(arr);
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(chars);
    }

    @When("I type in the first option max characters")
    public void iTypeInTheFirstOptionMaxCharacters() {
        char[] arr = new char[1000];
        for (int i=0; i<arr.length;i++)
        {
            arr[i]='B';
        }
        String chars = new String(arr);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(chars);
    }

    @When("I type in the second option max characters")
    public void iTypeInTheSecondOptionMaxCharacters() {
        char[] arr=new char[1000];
        for (int i=0; i< arr.length; i++)
        {
            arr[i]='C';
        }
        String chars = new String(arr);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(chars);

    }
}

