package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextQShowStopStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I type {string} in the {string} input field")
    public void iTypeInTheInputField(String email, String field) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='"+field+"']")).sendKeys(email);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String button) {
        if(button.equalsIgnoreCase("Give Assignment")){
            getDriver().findElement(By.xpath("//*[text()='Give Assignment']")).click();
        }else{
            getDriver().findElement(By.xpath("//*[contains(text(),'"+button+"')]")).click();
        }
    }

    @And("I wait for {int} sec while page is uploading")
    public void iWaitForSecWhilePageIsUploading(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @When("I navigate to {string} link and click on it")
    public void iNavigateToLinkAndClickOnIt(String link) {
        getDriver().findElement(By.xpath("//*[text()='"+link+"']")).click();
    }

    @And("I click on add question")
    public void iClickOnAddQuestion() {
        getDriver().findElement(By.xpath("//*[text()='add_circle']")).click();
    }

    @Then("question should be indicated with an {string}")
    public void questionShouldBeIndicatedWithAn(String ast) {
        String actual=getDriver().findElement(By.xpath("//*[contains(text(),'Q1*')]")).getText();
        assertThat(actual.contains(ast)).isTrue();
    }

    @Then("I should see quiz title {string} in the list of quizzes")
    public void iShouldSeeQuizTitleInTheListOfQuizzes(String title) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Karyna Show-Stopper')]")).isDisplayed();
    }

    @Then("I should see a {string} text")
    public void iShouldSeeAText(String text) {
        String actual= getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).getText();
        assertThat(actual.contains(text)).isTrue();

    }

    @When("I click on preview of the quiz {string}")
    public void iClickOnPreviewOfTheQuiz(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'Karyna Show-Stopper')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'"+title+"')]/../../..//*[text()='Preview']")).click();
    }

    @When("I click on {string} group code")
    public void iClickOnGroupCode(String code) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+code+"')]/../..")).click();
    }

    @Then("student with a name {string} should be chosen")
    public void studentWithANameShouldBeChosen(String name) {
        getDriver().findElement(By.xpath("//*[contains(@class,'checked')]")).isSelected();
        String name1=getDriver().findElement(By.xpath("//mat-card[@class='page mat-card']")).getText();
        assertThat(name1.contains(name)).isTrue();
    }

    @When("I choose quiz title as {string}")
    public void iChooseQuizTitleAs(String title) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Karyna Show-Stopper')]")).click();
    }

    @When("I click on {string} drop-down list")
    public void iClickOnDropDownList(String dropdown) {
        getDriver().findElement(By.xpath("//*[text()='"+dropdown+"']/..")).click();
    }

    @When("I navigate back")
    public void iNavigateBack() {
        getDriver().navigate().back();
    }

    @When("I confirm Log Out")
    public void iConfirmLogOut() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Confirmation')]/..//*[text()='Log Out']")).click();
    }

    @When("I click on Grade button for the quiz name {string}")
    public void iClickOnGradeButtonForTheQuizName(String title) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+title+"')]/..//*[contains(text(),'Grade')]")).click();
    }

    @When("I add points to {int}")
    public void iAddPointsTo(int points) {
        for (points=0; points<5; points ++){
            getDriver().findElement(By.xpath("//*[@class='buttons']//*[contains(text(),'+')]")).click();
        }
    }


    @Then("I should not see a {string} text")
    public void iShouldNotSeeAText(String text) {
        String actual = getDriver().findElement(By.xpath("//*[@class='result']")).getText();
        assertThat(actual.contains(text)).isFalse();
    }

    @When("I delete quiz {string} from the list")
    public void iDeleteQuizFromTheList(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'Karyna Show-Stopper')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[contains(text(),'"+title+"')]/../../..//*[text()='Delete']")).click();
    }

    @Then("I should not see a {string} quiz")
    public void iShouldNotSeeAQuiz(String text) {
        String quiz = getDriver().findElement(By.xpath("//*[@class='quizzes']")).getText();
        assertThat(quiz.contains(text)).isFalse();
    }

    @When("I confirm Deleting a quiz")
    public void iConfirmDeleting() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Confirmation')]/..//*[text()='Delete']")).click();
    }

    @When("I choose {string} question for question number {string}")
    public void iChooseQuestionForQuestionNumber(String type, String num) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Q"+num+"')]/../../..//*[contains(text(),'"+type+"')]")).click();
    }

    @When("I type in question field text {string} for question {string}")
    public void iTypeInQuestionFieldForQuestion(String text, String num) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Q"+num+"')]/../../..//*[@formcontrolname='question']")).sendKeys(text);
    }

    @And("I mark {string} question for question number {string}")
    public void iMarkQuestionForQuestionNumber(String text, String num) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Q"+num+"')]/../../..//*[contains(text(),'"+text+"')]")).click();
    }

    @Then("question number {string} should not be indicated with an {string}")
    public void questionNumberShouldNotBeIndicatedWithAn(String num, String ast) {
        String req=getDriver().findElement(By.xpath("//*[contains(text(),'Q"+num+"')]")).getText();
        assertThat(req.contains(ast)).isFalse();
    }

    @And("question number {string} should be indicated with an {string}")
    public void questionNumberShouldBeIndicatedWithAn(String num, String ast) {
        String req=getDriver().findElement(By.xpath("//*[contains(text(),'Q"+num+"')]")).getText();
        assertThat(req.contains(ast)).isTrue();
    }
}
