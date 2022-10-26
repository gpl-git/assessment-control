package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class MartinASKAuto {

//    @Given("I open {string} page")
//    public void iOpenPage(String url) {
//        if (url.equals("login")) {
//            getDriver().get("http://ask-qa.portnov.com/#/login");
//        } else if (url.equals("registration")) {
//            getDriver().get("http://ask-qa.portnov.com/#/registration");
//        } else {
//            System.out.println("This url is not supported: " + url);
//        }
//
//    }

//    @And("I wait for {int} sec")
//    public void iWaitForSec(int sec) throws InterruptedException {
//        Thread.sleep(sec * 1000);
//    }

//    @When("I type {string} for teacher user")
//    public void iTypeForTeacherUser(String email) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
//    }

//    @And("I type {string} as password")
//    public void iTypeAsPassword(String password) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
//    }

//    @When("I click {string} button")
//    public void iClickButton(String btnName) {
//        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
//    }

//    @Then("{string} page will be displayed")
//    public void pageWillBeDisplayed(String expectedUrl) {
//        String curUrl = getDriver().getCurrentUrl();
//        assertThat(curUrl.contains(expectedUrl)).isTrue();
//    }

//    @When("I click on {string} menu item")
//    public void iClickOnMenuItem(String menuItem) {
//        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
//    }


    @When("I click on {string}")
    public void iClickOn(String xpath) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }


//    @And("I type {string} as quiz title")
//    public void iTypeAsQuizTitle(String quizName) {
//        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizName);
//    }

    @And("I click  {string}")
    public void iClick(String xpath) {
        getDriver().findElement(By.xpath("//button[@type='button']//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string}")
    public void iSelect(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I type {string}")
    public void iType(String nameQuiz) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(nameQuiz);
    }


//    @Then("I type {string} into {string}")
//    public void iTypeInto(String questionContent, String questionNum) {
//        getDriver().findElement(By.xpath("//textarea[@placeholder='" + questionNum + "']")).sendKeys(questionContent);
//    }

    @And("I select {string} as the correct answer")
    public void iSelectAsTheCorrectAnswer(String checkBox) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='Option 1*']/../../../../../mat-checkbox")).click();
    }

    @And("I click on {string} button")
    public void iClickOnButton(String name) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + name + "')]")).click();
    }


    @And("I verify saved {string} in displayed in quizzes")
    public void iVerifySavedInDisplayedInQuizzes(String quizName) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]")).isDisplayed()).isTrue();
    }

    @Then("I edit the quiz")
    public void iEditTheQuiz() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Edit')]")).click();

    }

    @Then("I clear text field of {string}")
    public void iClearTextFieldOf(String option2) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + option2 + "']")).clear();
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+option2+"']")).sendKeys("");
        getDriver().findElement(By.xpath("//form")).click();
    }


//    @Then("I click on Quiz Title title")
//    public void iClickOnQuizTitleTitle() {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Delete')]")).click();
//        getDriver().findElement(By.xpath("//ac-modal-confirmation[@class='ng-star-inserted']/..//span[contains(text(),'Delete')]")).click();
//
//    }


//    @Then("I Edit quiz")
//    public void iEditQuiz() {
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Edit')]")).click();
//        getDriver().findElement(By.xpath("//mat-accordion[@formarrayname='questions']")).click();
//        getDriver().findElement(By.xpath(""))
//
//
//    }
//


    @Then("I delete the quiz")
    public void iDeleteTheQuiz() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz Demo Martin - Automation')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation[@class='ng-star-inserted']/..//span[contains(text(),'Delete')]")).click();

    }


    @Then("the button {string} is disabled")
    public void theButtonIsDisabled(String saveButton) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + saveButton + "')]")).isEnabled()).isFalse();
    }

    @Then("the button {string} is enabled")
    public void theButtonIsEnabled(String saveButton) {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'" + saveButton + "')]")).isEnabled()).isTrue();
    }


    @And("I click on first question")
    public void iClickOnFirstQuestion() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).click();
    }

    @And("I should see error message")
    public void iShouldSeeErrorMessage() {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1: Option')]/../../..//mat-error[contains(text(),'This field is required')]")).isDisplayed()).isTrue();

    }

    @Then("I type text {string} into {string}")
    public void iTypeTextInto(String questionContent, String questionNum) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='" + questionNum + "']")).sendKeys(questionContent);
    }
}





