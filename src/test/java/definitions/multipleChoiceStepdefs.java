package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class multipleChoiceStepdefs {
    @Then("I click {string} button and Sing in as a teacher")
    public void iClickButtonAndSingInAsATeacher(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
        Thread.sleep(2000);
    }



    @Then("I click {string} button to open List of Quizzes")
    public void iClickButtonToOpenListOfQuizzes(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'edit')]")).click();
        Thread.sleep(2000);
    }

    @Then("I click {string} button to create new quiz")
    public void iClickButtonToCreateNewQuiz(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'Create New Quiz')]/../..//button[@class='mat-raised-button mat-primary']")).click();
        Thread.sleep(3000);
    }

    @Then("I navigete to {string}")
    public void iNavigeteTo(String arg0) throws InterruptedException {
        getDriver().get("http://ask-qa.portnov.com/#/quiz-builder");
        Thread.sleep(2000);

    }

    @Then("I type {string} in Title of the Quiz")
    public void iTypeInTitleOfTheQuiz(String titleQuiz) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@class='header-form-group']/../..//input")).sendKeys(titleQuiz);

    }

    @Then("I click  button to add Question")
    public void iClickButtonToAddQuestion() {
        getDriver().findElement(By.xpath("//div[@class='controls ng-star-inserted']//button[@class='mat-button mat-primary']")).click();
    }

    @Then("I click button Multiple Choice")
    public void iClickButtonMultipleChoice() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Multiple-Choice')][@class='mat-radio-label-content']")).click();
    }

    @Then("I type {string} into Question field")
    public void iTypeIntoQuestionField(String question) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(question);
        Thread.sleep(2000);

    }


    @Then("I type {string} in field Option")
    public void iTypeInFieldOption(String option1) {
        getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys(option1);
    }

    @Then("I type {string} in second field Option")
    public void iTypeInSecondFieldOption(String option2) {
        getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys(option2);
    }

    @Then("I click button to choose right Option")
    public void iClickButtonToChooseRightOption() {
        getDriver().findElement(By.xpath("")).click();
    }


    @And("I type {string} in field Option {int}")
    public void iTypeInFieldOption(String option, int counter) {
//        for (int i=0; i<=counter; i++){
        if (counter == 1) {
            getDriver().findElement(By.xpath("//*[@placeholder='Option 1*']")).sendKeys(option);
        } else if (counter==2){
            getDriver().findElement(By.xpath("//*[@placeholder='Option 2*']")).sendKeys(option);
        } else if (counter==3){
            getDriver().findElement(By.xpath("//*[@placeholder='Option 3*']")).sendKeys(option);
        } else if (counter==4){
            getDriver().findElement(By.xpath("//*[@placeholder='Option 4*']")).sendKeys(option);
        }
    }

    @And("I click to add Option")
    public void iClickToAddOption() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Add Option')]")).click();
    }

    @Then("I select {string} type")
    public void iSelectType(String type) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+type+"')]")).click();
    }

    @And("I wait {int} sec")
    public void iWaitSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @When("I type {string} as question title")
    public void iTypeAsQuestionTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(title);
    }
}




