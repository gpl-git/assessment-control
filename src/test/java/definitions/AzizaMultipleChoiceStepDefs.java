package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class AzizaMultipleChoiceStepDefs {
    private String link;
    private String questionNumber;

    @Given("I navigate {string} page")
    public void iNavigatePage(String page) {
        if (page.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }


        }

        @When("I enter email {string}")
    public void iEnterEmail(String username) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click sign in")
    public void iClickSignIn() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @And("I click on {string}")
    public void iClickOn(String quizzes) {
        getDriver().findElement(By.xpath("//h5[text()='Quizzes']")).click();
    }


    @And("I click {string}")
    public void iClick(String newQuiz) {
        getDriver().findElement(By.xpath("//span[text()='Create New Quiz']")).click();
    }

    @When("I type {string} as the title")
    public void iTypeAsTheTitle(String QuizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(QuizTitle);
    }

    @And("I click add a question")
    public void iClickAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} question")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }


    @When("I type {string} as {string} text field {string}")
    public void iTypeAsTextField(String questionText, String questionNumber, String questionField) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNumber+"')]/../../..//*[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I check box for {string} question")
    public void iCheckBoxForQuestion(String checkbox) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']/../../../../..//div[@class='mat-checkbox-inner-container']")).click();

    }

    @Then("I press {string} button")
    public void iPressButton(String save) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }
}


