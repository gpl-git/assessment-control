package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class QuizTitleGalinaGStepDefs {

    @Given("I navigate to {string} page ASK")
    public void iNavigateToPageASK(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @When("I type email {string} for teacher user")
    public void iTypeEmailForTeacherUser(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click the {string} button")
    public void iClickTheButton(String signinbutton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+signinbutton+"')]")).click();
    }

    @Then("the ASK {string} page should be displayed")
    public void thePageASKShouldBeDisplayed(String expectedaddr) {
        String curUrl = getDriver().getCurrentUrl();
        assertThat(curUrl.contains(expectedaddr)).isTrue();
    }

    @When("I click on {string} from menu")
    public void iClickOnFromMenu(String item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+item+"')]")).click();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String quizbutton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+quizbutton+"')]")).click();
    }

    @When("I type the title of the Quiz {string}")
    public void iTypeTheTitleOfTheQuiz(String quiztitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quiztitle);
    }

    @And("I add the Question")
    public void iAddTheQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I choose {string} question")
    public void iChooseQuestion(String TypeQuestion) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+TypeQuestion+"')]")).click();
    }

    @When("I type the question title {string}")
    public void iTypeTheQuestionTitle(String questionTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionTitle);

    }

    @And("I type {string} as {string}")
    public void iTypeAs(String Text, String optionNr) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='"+optionNr+"']")).sendKeys(Text);
    }

    @Then("I choose the {string} as the correct answer")
    public void iChooseTheAsTheCorrectAnswer(String answer) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='"+ answer+ "']/../../../../../mat-radio-button")).click();
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String savebutton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+savebutton+"')]")).click();
    }

    @Then("quiz {string} is present on the list of quizzes")
    public void quizIsPresentOnTheListOfQuizzes(String Quiztitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+Quiztitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete the quiz {string}")
    public void iDeleteTheQuiz(String quiztitle) throws InterruptedException{
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quiztitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quiztitle+"' )]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @When("I enter {int} of alphanumeric characters as title of the Question")
    public void iEnterOfAlphanumericCharactersAsTitleOfTheQuestion(int number) {
        boolean useletters = true;
        boolean usenumbers = true;
        String generatedString = RandomStringUtils.random(number, useletters, usenumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']")).sendKeys(generatedString);

    }

    @Then("the error message should be displayed")
    public void theErrorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(@class,'mat-error ng-star-inserted')]")).isDisplayed()).isTrue();
    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDispalyed(String expectederror) {
        {
            String actualError = getDriver().findElement(By.xpath("//*[contains(@class,'mat-error ng-star-inserted')]")).getText();
            System.out.println(actualError);
            assertThat(actualError.equals(expectederror)).isTrue();
        }
    }
}
