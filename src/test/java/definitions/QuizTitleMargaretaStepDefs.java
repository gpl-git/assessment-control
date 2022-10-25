package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTitleMargaretaStepDefs {
    @Given("I'm opening {string} page")
    public void iMOpeningPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("This url is not supported: " + url);
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("I type {string} as an email")
    public void iTypeAsAnEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button")
    public void iClickButton(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]")).click();
    }

    @Then("{string} page will be displayed")
    public void pageWillBeDisplayed(String expectedUrl) {
        String currentUrl = getDriver().getCurrentUrl();
        assertThat(currentUrl.contains(expectedUrl)).isTrue();
    }

    @When("I click on {string} from menu item")
    public void iClickOnFromMenuItem(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @When("I type {string} as a quiz title")
    public void iTypeAsAQuizTitle(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I clear element with xpath {string}")
    public void iClearElementWithXpath(String textName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).clear();
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//mat-error[(text()='This field is required')]")).isDisplayed()).isTrue();
    }

    @And("I click outside input field")
    public void iClickOutsideInputField() {
        getDriver().findElement(By.xpath("//form")).click();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedError) {
        String actualError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actualError.equals(expectedError)).isTrue();
    }

    @Then("element {string} should be present")
    public void elementShouldBePresent(String required) {
        assertThat(getDriver().findElement(By.xpath("//input[@aria-required='false']")).isDisplayed()).isTrue();
    }

    @When("element with xpath should be present")
    public void elementWithXpathShouldBePresent() {
        assertThat(getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).isDisplayed()).isTrue();
    }

    @When("I select {string} question")
    public void iSelectQuestion(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into {string}")
    public void iTypeInto(String questionText, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }
}




 
    
