package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultiChoiceTexStepDefsKS {
    private Object getDriver;
    private Object elementDisplayedAndMatches;

    @Given("I go to {string} page KS")
    public void iGoToPageKS(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site '" + url + "' is not supported.");
        }
        {

        }
    }

    @When("I type {string} into email input field KS")
    public void iTypeIntoEmailInputFieldKS(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }


    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click {string} button KS")
    public void iClickButtonKS(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
    }

    @When("I click {string} menu item KS")
    public void iClickMenuItemKS(String item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + item + "')]")).click();
    }

    @And("I wait for {int} sec KS")
    public void iWaitForSecKS(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I enter {string} as quiz title KS")
    public void iEnterAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a question KS")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question KS")
    public void iSelectQuestionKS(String questionType) {
        getDriver().findElement(By.xpath("//mat-radio-button/label//*[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I type {string} into {string} textarea KS")
    public void iTypeIntoTextareaKS(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I type {string} into {string} field in {string} KS")
    public void iTypeIntoFieldInKS(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string} KS")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../../mat-checkbox")).click();
    }

    @Then("Quiz {string} is displayed in the the list of quizzes KS")
    public void quizIsDisplayedInTheTheListOfQuizzesKS(String title) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).isDisplayed()).isTrue();

    }

    @Then("error message is displayed and contains text {string}")
    public void errorMessageIsDisplayedAndContainsText(String expectedMessage) {
        elementDisplayedAndMatches("//div[contains(text(),'Quiz is not completed. Check highlighted with red']", expectedMessage);
    }

    private void elementDisplayedAndMatches(String s, String expectedMessage) {
    }


    @And("I type {int} symbol\\(s) into {string} field in {string} KS")
    public void iTypeSymbolSIntoFieldInKS(int count, String optionNum, String questionNum) {
        String optionString = "";
        for (int i = 0; i < count; i++) {
            optionString = optionString + 's';
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).sendKeys(optionNum);
        }

    }


    @And("I type {int} characters  into question  field in {string} KS")
    public void iTypeCharactersIntoFieldInKS(int numChar,  String questionNum) {
        boolean useLetters =true;
        boolean useNumbers =true;
        String generatedString = RandomStringUtils.random(numChar, useLetters,useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(generatedString);
    }

    @Then("error message should be displayed KS")
    public void errorMessageShouldBeDisplayedKS() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'error')]")).isDisplayed()).isTrue();
    }
}



















