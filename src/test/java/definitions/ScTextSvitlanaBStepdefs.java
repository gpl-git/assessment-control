package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class ScTextSvitlanaBStepdefs {

    @Given("Person goes to {string} page")
    public void personGoesToPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println(url + " is not supported");
        }
    }

    @When("Person types {string} into email field")
    public void personTypesIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);

    }

    @And("Person types {string} into password field")
    public void personTypesIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);

    }

    @When("Person clicks {string} button")
    public void personClicksButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }


    @And("Person waits for {int} sec")
    public void personWaitsForSec(int sec) throws InterruptedException {
        Thread.sleep(1000);
        
    }

    @When("Person clicks {string} menu item")
    public void personClicksMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("Person types {string} in title field")
    public void personTypes(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);

    }

    @And("Person adds question")
    public void personAddsQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
        
    }

    @Then("Person selects {string} question type")
    public void personSelectsQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();

    }

    @When("Person types {string} into textarea field into {string}")
    public void personTypesIntoTextareaFieldInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("Person types {string} into {string} field in {string}")
    public void personTypesIntoFieldIn(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']")).sendKeys(optionText);
        
    }

    @Then("Person select {string} as correct option in {string}")
    public void personSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']/../../../../..//mat-radio-button")).click();
    }

    @Then("title {string} is displayed on list of quizzes")
    public void titleIsDisplayedOnListOfQuizzes(String title) {
       List <WebElement> titles = getDriver().findElements(By.xpath("//mat-panel-title"));
        for (WebElement element:titles){
            if (element.getText().equals(title)) {
                element.isDisplayed();
            
        }
           }
       }


    @And("Person deletes {string} from list of quizzes")
    public void personDeletesFromListOfQuizzes(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);

    }

    @Then("question text error message should be displayed {string}")
    public void questionTextErrorMessageShouldBeDisplayed(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actMessage.equals(expMessage)).isTrue();
    }

    @When("Person types {int} alphanumeric characters into textarea field into {string}")
    public void personTypesAlphanumericCharactersIntoTextareaFieldInto(int number, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
        System.out.println(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(generatedString);
    }

    @Then("error message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String expErrorMessage) {
        String actErrorMessage = getDriver().findElement(By.xpath("//mat-error', "+expErrorMessage+"')]")).getText();
        assertThat(actErrorMessage.equals(expErrorMessage)).isTrue();
    }
}



        

