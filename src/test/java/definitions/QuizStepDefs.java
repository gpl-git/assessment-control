package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @Given("I open {string} page [MKs]")
    public void iOpenPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url is not supported: " + url);
        }

    }

    @And("I wait for {int} sec [MKs]")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I type {string} for teacher user [MKs]")
    public void iTypeForTeacherUser(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as password [MKs]")
    public void iTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button [MKs]")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("{string} page will be displayed [MKs]")
    public void pageWillBeDisplayed(String expectedUrl) {
        String curUrl = getDriver().getCurrentUrl();
      assertThat(curUrl.contains(expectedUrl)).isTrue();
    }

    @When("I click on {string} menu item [MKs]")
    public void iClickOnMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I type {string} as quiz title [MKs]")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question [MKs]")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question [MKs]")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string} [MKs]")
    public void iTypeInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("I type {string} as {string} in {string} [MKs]")
    public void iTypeAsIn(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }


    @Then("I select {string} as correct option in {string} [MKs]")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+ optionNum+ "']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} is displayed on the list of quizzes [MKs]")
    public void quizIsDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete quiz {string} [MKs]")
    public void iDeleteQuiz(String title) throws InterruptedException {
    getDriver()
        .findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]"))
        .click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"' )]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @Then("I type {string} into FirstOption")
    public void iTypeIntoFirstOption(String text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(text);
    }

    @Then("I type {string} into SecondOption")
    public void iTypeIntoSecondOption(String text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(text);
    }

    @Then("required quontity of characters should be present in OptionFiedld{int}")
    public void requiredQuontityOfCharactersShouldBePresentInOptionFiedld(int arg0) {

    }

    @Then("required quantity of characters {string} should be present in OptionField1")
    public void requiredQuantityOfCharactersShouldBePresentInOptionFeild(String expText) {
        String actText = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).getText();
        assertThat(actText.equals(expText)).isTrue();
    }

    @Then("required quantity of characters {string} should not be present in OptionField1")
    public void requiredQuantityOfCharactersShouldNotBePresentInOptionField(String expText) {
        String actText = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).getText();
        assertThat(actText.equals(expText)).isFalse();
    }

    @And("I click on Save button [MKs]")
    public void iClickOnSaveButtonMKs() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("Option1 quiz error should be displayed")
    public void optionQuizErrorShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-2']")).isDisplayed()).isTrue();
    }

    @And("I click on element with xpath {string} [MKs]")
    public void iClickOnElementWithXpathMKs(String path) {
        getDriver().findElement(By.xpath(path)).click();
    }

    @Then("error messages should not be displayed")
    public void errorMessagesShouldNotBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-5']")).isDisplayed()).isFalse();
    }
}
