package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceQuestionAndreiVStepdefs {
    @And("I select {string} checkbox as correct option in {string}")
    public void iSelectCheckboxAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../../../mat-checkbox")).click();

    }

    @Then("Error message {string} should be displayed in Question field in {string}")
    public void errorMessageShouldBeDisplayedInFieldIn(String message, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']/../../../div[@class='mat-input-subscript-wrapper mat-form-field-subscript-wrapper']/..//mat-error[contains(text(),'"+message+"')]")).isDisplayed();
    }

    @Then("Error message {string} should be displayed in {string} field in {string}")
    public void errorMessageShouldBeDisplayedInFieldIn(String message, String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='"+optionNumber+"']/../../../div[@class='mat-input-subscript-wrapper mat-form-field-subscript-wrapper']/..//mat-error[contains(text(),'"+message+"')]")).isDisplayed();
    }

    @Then("Error message {string} should be displayed in {string}")
    public void errorMessageShouldBeDisplayedIn(String message, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//div[@class='choice-error ng-star-inserted'][contains(text(),'"+message+"')]")).isDisplayed();
    }

    @When("I select Include Other text area option in {string}")
    public void iSelectIncludeOtherTextAreaOptionIn(String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//span[@class='mat-checkbox-label']/../span[contains(text(),'text area option')]")).click();

    }

    @Then("The PREVIEW MODE window should be displayed")
    public void theWindowShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-dialog-container/ac-quiz-preview")).isDisplayed();
    }

    @When("I type {string} into required fields in {string}")
    public void iTypeIntoRequiredFieldsIn(String message, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(message);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys(message);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys(message);
    }

    @When("I type {int} characters into {string}")
    public void iTypeCharactersInto(int numChars, String questionNumber) {
        int length = numChars;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='Option 1*']")).sendKeys(generatedString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+questionNumber+"')]/../../..//textarea[@placeholder='Option 2*']")).sendKeys(generatedString);
    }
}
