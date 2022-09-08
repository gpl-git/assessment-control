package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class QuizTQ_SvetlanaStepDefs
{

        @Given("I go to {string} page ss")
        public void iGoToPageSs(String url) {
                if(url.equals("login")){
                        getDriver().get("http://ask-qa.portnov.com/#/login");
                }else if(url.equals("registration")){
                        getDriver().get("http://ask-qa.portnov.com/#/registration");
                }else {
                        System.out.println("The site is not supported " + url);
                }

        }

        @When("I type {string} into email field ss")
        public void iTypeIntoEmailFieldSs(String email) {
                getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);

        }

        @And("I type {string} into  password field ss")
        public void iTypeIntoPasswordFieldSs(String password) {
                getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
                
        }

        @When("I click {string} button ss")
        public void iClickButtonSs(String btnName) {
                getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
 }

        @And("I wait {int} sec ss")
        public void iWaitSecSs(int sec) throws InterruptedException {
                sleep(1000* sec);
        }



        @When("I click {string} menu item ss")
        public void iClickMenuItemSs(String menuItem) {
                getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
        }


        @When("I type {string} as quiz title ss")
        public void iTypeAsQuizTitleSs(String quizTitle) {
                getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);

}

        @And("I add a question ss")
        public void iAddAQuestionSs() {
                getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();

        }


        @When("I select {string} question type ss")
        public void iSelectQuestionTypeSs(String questionType) {
                getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
        }

        @When("I enter {string} into {string} ss")
        public void iEnterIntoSs(String questionText, String questionNum) {
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@formcontrolname='question']")).sendKeys(questionText);

        }

        @Then("I verify that {string} is displayed on the list of quizzes ss")
        public void iVerifyThatIsDisplayedOnTheListOfQuizzesSs(String quizTitle) {
                assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();

        }

        @And("I delete {string} from the list of quizzes ss")
        public void iDeleteFromTheListOfQuizzesSs(String quizTitle) {
                assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).isDisplayed()).isTrue();
        }

        @Then("error message {string} is displayed ss")
        public void errorMessageIsDisplayedSs(String errorMessage) {
                assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+errorMessage+"')]")).isDisplayed()).isTrue();

        }

        @When("I type {int} alphanumeric characters into {string} ss")
        public void iTypeAlphanumericCharactersIntoSs(int num, String questionNumber) {
                boolean useLetters = true;
                boolean useNumbers = true;

      String generatedString = RandomStringUtils.random(num, useLetters, useNumbers);
      System.out.println(generatedString);
      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//*[@formcontrolname='question']")).sendKeys(generatedString);

        }

        @Then("I verify that {string} is not displayed on the list of quizzes ss")
        public void iVerifyThatIsNotDisplayedOnTheListOfQuizzesSs(String quizNotDisplayed) {
                assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizNotDisplayed+"')]")).isDisplayed()).isFalse();

        }

        @When("I enter an empty space {string} into {string} ss")
        public void iEnterAnEmptySpaceIntoSs(String questionText, String questionNumber) {
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[@formcontrolname='question']")).sendKeys(questionText);

        }
}


