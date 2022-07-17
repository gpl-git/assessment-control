package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static support.TestContext.getDriver;

public class MultipleStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
//        if (url.equals("Login")){
        getDriver().get("http://ask-qa.portnov.com/#/login");
//        }else if (url.equals("registration")){
//            getDriver().get("http://ask-qa.portnov.com/#/registration");
//        }else{
//            System.out.println("This sie " +url + " is not supported.");
//    }

    }

    @Then("I add option")
    public void iAddOption() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();



    }

    @And("I check {string} as correct option in {string}")
    public void iCheckAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1: The old capital of the U.S.')]/../../..//textarea[@placeholder='Option 3*']/../../../../../mat-checkbox")).click();
    }

    @Then("I select {string}Other{string} as right option in {string}")
    public void iSelectOtherAsRightOptionIn(String option, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1: The old capital of the U.S.')]/../../..//span[contains(text(),'Include \"Other\" text area option for this question?')]/../../../mat-checkbox")).click();
    }

    @Then("quiz {string} should be shown on the list of quizzes")
    public void quizShouldBeShownOnTheListOfQuizzes(String quizTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]")).isDisplayed()).isTrue();
    }

    @And("I preview {string} quiz it shows the {string} option")
    public void iPreviewQuizItShowsTheOption(String quizTitle, String option) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]/../../..//*[contains(text(),'Preview')]")).click();
        getDriver().findElement(By.xpath("//h4[contains(text(),'1 K 2')]/..//textarea[@formcontrolname='textAnswer']")).isDisplayed();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();

    }

    @When("I remove the {string} quiz")
    public void iRemoveTheQuiz(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]/../../..//span[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]")).click();


    }

    @Then("I go back to {string}")
    public void iGoBackTo(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'1 K 2')]")).click();
    }
}
