package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQuestionShowStopperStepdefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "login": {
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            }
            case "registration": {
                getDriver().get("http://ask-qa.portnov.com/#/registration");
                break;
            }
            default: {
                System.out.println("The site " + page + " is not supported");
            }
        }
    }

    @And("I wait for {int} second")
    public void iWaitForSecond(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I fill in {string} into email field")
    public void iFillInIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I put {string} into password field")
    public void iPutIntoPasswordField(String pwd) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pwd);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @Then("I verify url as {string}")
    public void iVerifyUrlAs(String url) {
        String actualUrl = getDriver().getCurrentUrl();
        assertThat(actualUrl.contains(url)).isTrue();
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String tab) {
        getDriver().findElement(By.xpath("//h5[text()='" + tab + "']")).click();
    }

    @And("I put {string} as quiz title")
    public void iPutAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add a textual question")
    public void iAddATextualQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @And("I select {string} textual question type")
    public void iSelectTextualQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type in question text {string} into {string}")
    public void iTypeInQuestionTextInto(String questionText, String qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + qestionNum + "')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionText);
    }

    @And("I select checkbox {string}")
    public void iSelectCheckbox(String arg0) {
        getDriver().findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']")).click();
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @Then("the quiz {string} should be displayed on the list of quizzes")
    public void theQuizShouldBeDisplayedOnTheListOfQuizzes(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).isDisplayed()).isTrue();
    }

    @Then("I click on {string} dropdown element")
    public void iClickOnDropdownElement(String arg0) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'\"Textual Question - Show-Stopper\"')]")).click();

    }

    @And("I verify that quiz has a show-stopper question")
    public void iVerifyThatQuizHasAShowStopperQuestion() {
        String actualResult = getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).getText();
        assertThat(actualResult.contains("Show-Stopper")).isTrue();
    }

    @And("I push on {string} button")
    public void iPushOnButton(String closeButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @And("I delete quiz {string} from list of quizzes")
    public void iDeleteQuizFromListOfQuizzes(String title) throws InterruptedException {
            getDriver().findElement(By.xpath("//body/ac-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/main[1]/ac-quizzes-list[1]/mat-card[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[1]/button[2]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/ac-modal-confirmation[1]/div[2]/button[2]/div[1]")).click();
        }
}