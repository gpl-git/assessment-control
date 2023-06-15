package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Law_ShowstopperDefs {
    @Given("I go to {string}")
    public void iGoTo(String url) {
        if (url.equals("ASK Login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else {
            System.out.println("This webiste" + url + "is not working.");
        }
    }


    @When("I type {string} into e-input Law")
    public void iTypeIntoEInput(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type {string} into p-input Law")
    public void iTypeIntoPInput(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I click {string} btn Law")
    public void iClickBtn(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("I click {string} on the sidebar")
    public void iClickOnTheSidebar(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(), '"+menuItem+"')]")).click();
    }

    @When("I type {string} as title for Quiz")
    public void iTypeAsTitleForQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
    }

    @Then("I add the first question Law")
    public void iAddTheFirstQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }


    @Then("I click {string} radio button")
    public void iClickRadioButton(String chkbox) {
        getDriver().findElement(By.xpath(
                "//div[@class='mat-checkbox-inner-container']")).click();
    }

    @And("I type {string} into qfield of {string}")
    public void iTypeIntoQfieldOf(String qText, String qNum) {
        getDriver().findElement(
                By.xpath("//mat-panel-title[contains(text(),'"+qNum+"')]" +
                        "/../../..//textarea[@formcontrolname='question']")).sendKeys(qText);
    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String resultText) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(resultText);

    }

    @When("I select {string} as a correct answer in {string}")
    public void iSelectAsACorrectAnswerIn(String aNum, String qNum) {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+qNum+"')]/../../..//textarea[@placeholder='"+aNum+"*']" +
                        "/../../../../..//mat-radio-button")).click();
    }

    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("I verify {string} is displayed")
    public void iVerifyIsDisplayed(String xpath) {


    }

    @Then("I preview {string} to verify Showstopper is displayed")
    public void iPreviewToVerifyShowstopperIsDisplayed(String quizTitle) {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Preview']")).click();


    }




    @And("I verify {string} displays {string}")
    public void iVerifyDisplays(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualTo(text);
    }

    @Then("I click {string} to edit the quiz")
    public void iClickToEditTheQuiz(String quizTitle) {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'Law Showstopper')]")).click();
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'Law Showstopper')]/../../..//span[text()='Edit']")).click();
    }




    @Then("{string} displays {string} as a showstopper")
    public void displaysAsAShowstopper(String questionNum, String asterisk) {
        String result = getDriver().findElement(By.xpath("//*[contains(text(),'"+questionNum+"')]")).getText();
        assertThat(result.contains(asterisk)).isTrue();
    }


    @When("I check {string} in {string} Law")
    public void iCheckInLaw(String checkbox, String questionNum) {
        getDriver().findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']")).click();
    }


    @Then("I click on {string} as correct answer Law")
    public void iClickOnAsCorrectAnswerLaw(String checkbox) {
        getDriver().findElement(By.xpath("//mat-radio-button[@id='mat-radio-6']")).click();
    }


    @Then("I verify {string} is showing Law")
    public void iVerifyIsShowingLaw(String text) throws InterruptedException {
        String res = getDriver().findElement(By.xpath("//p[contains(@class,'show-stopper')]")).getText();
        System.out.println(res);
        Thread.sleep(1000);
        assertThat(res.contains(text)).isTrue();

    }

    @Then("I add {int} new question Law")
    public void iAddNewQuestion(int num) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();

        }

    @Then("I create a new question")
    public void iCreateANewQuestion(String questionType) {
        getDriver().findElement(By.xpath("//input[@id='mat-radio-14-input']")).click();
    }

    @And("I choose {string} the question type Law")
    public void iChooseTheQuestionTypeLaw(String questionType) {
        getDriver().findElement(By.xpath("")).click();
    }

    @Then("I add the second question Law")
    public void iAddTheSecondQuestionLaw() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
    }

    @Then("I click {string} in {string} Law")
    public void iClickInLaw(String checkBox, String questionNum) {
        getDriver().findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-17-input']")).click();
    }

    @When("I select second question type Law")
    public void iSelectSecondQuestionTypeLaw() {
        getDriver().findElement(By.xpath("//mat-radio-button[@id='mat-radio-72']")).click();
    }

    @Then("I close the dialog box Law")
    public void iCloseTheDialogBoxLaw() {
        getDriver().findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
    }

    @And("I delete {string} from the list of quizzes Law")
    public void iDeleteFromTheListOfQuizzesLaw(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath(
                "//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }


    @Then("I click {string} button as answer Law")
    public void iClickButtonAsAnswerLaw(String checkBox) {
        getDriver().findElement(By.xpath("//mat-radio-button[@id='mat-radio-37']")).click();
    }
}

