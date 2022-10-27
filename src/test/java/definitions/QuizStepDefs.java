package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else{
            System.out.println("This url is not supported: " + url);
        }

    }

    @And("I wait for {int} sec")
    public void iWaitForSec(long sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I type {string} for teacher user")
    public void iTypeForTeacherUser(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("{string} page will be displayed")
    public void pageWillBeDisplayed(String expectedUrl) {
        String curUrl = getDriver().getCurrentUrl();
      assertThat(curUrl.contains(expectedUrl)).isTrue();
    }

    @When("I click on {string} menu item")
    public void iClickOnMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+menuItem+"')]")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string}")
    public void iTypeInto(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("I type {string} as {string} in {string}")
    public void iTypeAsIn(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }


    @Then("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+ optionNum+ "']/../../../../../mat-radio-button")).click();
    }

    @Then("quiz {string} is displayed on the list of quizzes")
    public void quizIsDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete quiz {string}")
    public void iDeleteQuiz(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"' )]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
    }

    @Then("element with xpath {string} should have text as {string}")
    public void elementWithXpathShouldHaveTextAs(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualTo(text);
    }

    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("element with xpath {string} should be present")
    public void elementWithXpathShouldBePresent(String xpath) {
        assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(1);
    }
}
