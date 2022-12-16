package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultiChoiceOptionsElenaFStepdefs {
    @Given("I go to {string} page EF")
    public void iGoToPageEF(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Site '" + url + "' is not available.");
        }
    }


    @And("I wait for {int} sec -EF")
    public void iWaitForSecEF(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            // ignore
        }
    }


    @And("I click on {string} button -EF")
    public void iClickOnButtonEF(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]")).click();
    }

    @When("I click {string} menu item -EF")
    public void iClickMenuItemEF(String menuItem) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
    }

    @And("I click {string} button -EF")
    public void iClickButtonEF(String buttonName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]")).click();
    }

    @When("I enter valid credentials as a teacher -EF")
    public void iEnterValidCredentialsAsATeacherEF() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("ask_instr@aol.com");
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");
    }

    @When("I enter {string} as quiz title -EF")
    public void iEnterAsQuizTitleEF(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("I add a new question -EF")
    public void iAddANewQuestionEF() {
        getDriver().findElement(By.xpath("//button//mat-icon[text()='add_circle']")).click();
    }

    @When("I select {string} question -EF")
    public void iSelectQuestionEF(String questionType) {
        getDriver().findElement(By.xpath("//mat-radio-button/label//*[contains(text(),'" + questionType + "')]")).click();
    }

    @When("I click on {string} question textarea -EF")
    public void iClickOnQuestionTextareaEF(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@formcontrolname='question']")).click();
    }

    @And("I click on {string} field in {string} -EF")
    public void iClickOnFieldIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']")).click();
    }

    @Then("error message is displayed under question input field and contains text: {string} -EF")
    public void errorMessageIsDisplayedAndContainsText(String expectedMessage) {
        elementDisplayedAndMatches("//mat-panel-title[contains(text(),'Q1')]/../../..//mat-form-field[contains(@class, 'question')]//mat-error", expectedMessage);
    }

    @Then("error message is displayed under {string} input field and contains text: {string} -EF")
    public void errorMessageIsDisplayedUnderInputFieldAndContainsTextEF(String optionNum, String expectedMessage) {
        elementDisplayedAndMatches("//mat-panel-title[contains(text(),'Q1')]/../../..//textarea[@placeholder='" + optionNum + "']/../../..//mat-error", expectedMessage);
    }

    private void elementDisplayedAndMatches(String xpathExpression, String expectedMessage) {
        WebElement element = getDriver().findElement(By.xpath(xpathExpression));

        assertThat(element.isDisplayed()).isTrue();
        assertThat(element.getText()).isEqualTo(expectedMessage);
    }

    @When("I click on Settings button at {string} field in {string} -EF")
    public void iClickOnSettingsButtonAtFieldInEF(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../../button")).click();
    }

    @Then("the Delete element will be inactive -EF")
    public void theDeleteElementForFieldInWillBeInactiveEF() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//span[contains(text(), 'Delete Option')]/..")).isEnabled()).isFalse();
    }

    @And("I click on Close button")
    public void iClickOnCloseButtonAtFieldIn() {
        getDriver().findElement(By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//span[contains(text(), 'Close Menu')]/..")).click();
        //div[contains(@class, 'cdk-overlay-pane')]//span[contains(text(), 'Close Menu')]/..
    }

    @When("I add a new option -EF")
    public void iAddANewOptionEF() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//div[contains(@class,'add-option')]//button")).click();
        //mat-panel-title[contains(text(),'Q1')]/../../..//div[contains(@class,'add-option')]//button
    }

    @Then("the Delete element will be active -EF")
    public void theDeleteElementWillBeActiveEF() {
        assertThat(getDriver().findElement(By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//span[contains(text(), 'Delete Option')]/..")).isEnabled()).isTrue();
    }

    @And("I click on the Delete button  -EF")
    public void iClickOnTheDeleteElementForFieldInEF() {
        getDriver().findElement(By.xpath("//div[contains(@class, 'cdk-overlay-pane')]//span[contains(text(), 'Delete Option')]/..")).click();
    }

    @When("I add {int} new options")
    public void iAddNewOptions(int count) {
        for (int i = 0; i < count; i++) {
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//div[contains(@class,'add-option')]//button")).click();
        }
    }

    @Then("too many error message is displayed and contains text: {string}")
    public void tooManyErrorMessageIsDisplayedAndContainsText(String expectedMessage) {
        elementDisplayedAndMatches("//body//*[contains(text(), 'Max. 15 options are possible']", expectedMessage);
    }

    @When("I type {string} into {string} textarea -EF")
    public void iTypeIntoTextareaEF(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("I type {string} into {string} field in {string} -EF")
    public void iTypeIntoFieldInEF(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string} -EF")
    public void iSelectAsCorrectOptionInEF(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../..//mat-checkbox")).click();
    }

    @Then("preview window should be displayed and contain {string} title")
    public void previewWindowShouldBeDisplayedAndContainTitle(String expectedTitle) {

        elementDisplayedAndMatches("//ac-quiz-preview//h3", "PREVIEW MODE");
        elementDisplayedAndMatches("//ac-quiz-preview//ac-take-quiz//h4", expectedTitle);
        //h3[contains(text(),'PREVIEW MODE')]/../..//ac-quiz-preview
    }

    @When("I close the preview window")
    public void iCloseThePreviewWindow() {
        getDriver().findElement(By.xpath("//ac-quiz-preview//button/span[contains(text(),'Close')]")).click();
        //ac-quiz-preview//button/span[contains(text(),'Close')]
    }

    @Then("quiz {string} is displayed on the list of quizzes -EF")
    public void quizIsDisplayedOnTheListOfQuizzesEF(String expectedTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+expectedTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I delete quiz {string} -EF")
    public void iDeleteQuizEF(String expectedTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+expectedTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+expectedTitle+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'Delete')]")).click();

    }

    @And("I type {int} symbol\\(s) into {string} field in {string} -EF")
    public void iTypeCountSymbolIntoFieldInEF(int count, String optionNum, String questionNum) {
        String optionString = "";

        for(int i = 0; i < count; i++) {
            optionString = optionString + 's';
        }
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']")).sendKeys(optionString);

    }



}
