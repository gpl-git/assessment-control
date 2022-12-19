package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SingleChoiceAZStepdefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String link) {
        if (link.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else{
            System.out.println("Site '" + link + "' is not supported.");
        }
    }

    @When("I start typing {string} into email input field")
    public void iStartTypingIntoEmailInputField(String emailAddress) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(emailAddress);
    }

    @And("I start typing {string} into password field")
    public void iStartTypingIntoPasswordField(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @And("I wait for {int} sec AZ")
    public void iWaitForSecAZ(int second) throws InterruptedException {
        Thread.sleep(second*1000);
    }

    @When("I click on Quizzes on left side bar")
    public void iClickOnQuizzesOnLeftSideBar() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("I click Create New Quiz button AZ")
    public void iClickCreateNewQuizButtonAZ() {
        getDriver().findElement(By.xpath("//body/ac-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/main[1]/ac-quizzes-list[1]/mat-card[1]/div[2]/a[1]/button[1]"));
    }

    @When("I click {string} button AZ")
    public void iClickButtonAZ(String singIn) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + singIn + "')]")).click();
    }

    @Then("I enter title {string} for a quiz")
    public void iEnterTitleForAQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @And("I add a question AZ")
    public void iAddAQuestionAZ() {
        getDriver().findElement(By.xpath("//button//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question AZ")
    public void iSelectQuestionAZ(String questionType) {
        getDriver().findElement(By.xpath("//mat-radio-button/label//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string} textarea AZ")
    public void iTypeIntoTextareaAZ(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type {string} into {string} field in {string} AZ")
    public void iTypeIntoFieldInAZ(String optionText, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']")).sendKeys(optionText);
    }

    @Then("I select Show Stopper")
    public void iSelectShowStopper() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//span[contains(text(),'Show-Stopper')]")).click();
    }


    @Then("I verify {string} is is present")
    public void iVerifyIsIsPresent(String questionOne) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionOne+"')]")).isDisplayed()).isTrue();

    }

    @Then("I click on {string}")
    public void iClickOn(String quizA) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizA+"')]")).click();
    }

    @And("I preview {string}")
    public void iPreview(String quizAnna) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizAnna+"')]/../../..//span[contains(text(),'Preview')]")).click();
        Thread.sleep(1000);
    }

    @Then("{string} is displayed")
    public void isDisplayed(String showStopper) {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'"+showStopper+"')]")).isDisplayed()).isTrue();
    }

    @And("I edit {string}")
    public void iEdit(String quizAn) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizAn+"')]/../../..//span[contains(text(),'Edit')]")).click();
        Thread.sleep(1000);    }

    @When("I again select {string} question AZ")
    public void iAgainSelectQuestionAZ(String questionType) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//mat-radio-button/label//*[contains(text(),'"+questionType+"')]")).click();
    }

    @Then("I select Show Stopper again")
    public void iSelectShowStopperAgain() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//span[contains(text(),'Show-Stopper')]")).click();
    }

    @And("I verify only {string} is present")
    public void iVerifyOnlyIsPresent(String question) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+question+"')]")).isDisplayed()).isTrue();
    }

    @And("I verify that {string} is not present")
    public void iVerifyThatIsNotPresent(String question) {
        try {
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+question+"')]"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            boolean b = false;
        }
    }

    @And("I type {string} into the {string}")
    public void iTypeIntoThe(String text, String question) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2')]/../../..//textarea[@placeholder='"+question+"']")).sendKeys(text);
    }

    @And("I verify Show-Stopper is present next to Question two")
    public void iVerifyShowStopperIsPresentNextToQuestionTwo() {
        assertThat(getDriver().findElement(By.xpath("//mat-card//h5[contains(text(),'Question 2 / 2')]/..//p[contains(text(),'Show-Stopper Question')]")).isDisplayed()).isTrue();
    }


    @And("I delete question in {string}")
    public void iDeleteQuestionIn(String quiz) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2*: Question')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q2*: Question')]/../../..//span[contains(text(),'Delete Question')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[@type='button']//span[contains(text(),'Delete')]")).click();
    }

    @And("I again edit {string}")
    public void iAgainEdit(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Anna Quiz')]/../../..//span[contains(text(),'Edit')]")).click();
        Thread.sleep(1000);
    }

}
