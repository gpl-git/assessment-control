package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TotalQuestionJungDefs {
    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        if (url.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if(url.equalsIgnoreCase("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This site is not supported: " +url);
        }
    }

    @When("I type the {string} into email field")
    public void iTypeTheIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I enter the {string} as  password")
    public void iEnterTheAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click the button {string}")
    public void iClickTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }


    @When("I click on the {string} menu item")
    public void iClickOnTheMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @And("I wait for {int} sec[s]")
    public void iWaitForSecS(int sec) throws InterruptedException {
        Thread.sleep(1000* sec);
    }


    @When("I type the {string} as quiz title")
    public void iTypeTheAsQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add the question")
    public void iAddTheQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select the {string} question and {string} question type")
    public void iSelectTheQuestionAndQuestionType(String questionNumber, String questionType) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type the {string} into {string}")
    public void iTypeTheInto(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }


    @Then("I check the quiz {string} displayed on the list of quizzes")
    public void iCheckTheQuizDisplayedOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete the {string}")
    public void iDeleteThe(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }


    @And("I can see the {string} message")
    public void iCanSeeTheMessage(String quizMessage) {
        System.out.println("Quiz is not completed sign is displayed: "+getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//*[contains(text(), '"+quizMessage+ "')]")).isDisplayed());
    }

    @And("I type the {string} as {string} into {string}")
    public void iTypeTheAsInto(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']")).sendKeys(optionText);
    }

    @And("I click the Option add button")
    public void iClickTheOptionAddButton() {
        getDriver().findElement(By.xpath("//div[@class='add-option']/..//span[contains(text(), 'Add Option')]")).click();
    }

    @And("I select the {string} as correct option in {string}")
    public void iSelectTheAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-radio-button")).click();
    }

    @And("I click the {string} Option add button")
    public void iClickTheOptionAddButton(String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[contains(text(),'Add Option')]")).click();
    }

    @And("I select the {string} as correct multiple option in {string}")
    public void iSelectTheAsCorrectMultipleOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-checkbox")).click();
    }

    @And("I can see the over {int} quiz message {string}")
    public void iCanSeeTheOverQuizMessage(int quizNumber, String quizMessage) {
        System.out.println("No more than "+quizNumber+" questions allowed is displayed: "+getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//*[contains(text(), '"+quizMessage+ "')]")).isDisplayed());
    }
}
