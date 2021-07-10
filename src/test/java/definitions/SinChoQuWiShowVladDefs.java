package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;


public class SinChoQuWiShowVladDefs {
    @Then("I click {string} checkbox in {int} question")
    public void iClickCheckboxInQuestion(String checkBox, int qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input/..")).click();
    }

    @And("I select {string} question type using Vlad's method")
    public void iSelectQuestionTypeUsingVladSMethod(String questionType, int qestionNum) {
        qestionNum=1
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//div[contains(text(),'"+questionType+"')]")).click();
    }

    @Then("I move question number {int} {string}")
    public void iMoveQuestionNumber(int qestionNum, String upDownButton) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//span[contains(text(),'Move Question "+upDownButton+"')]/..")).click();

    }

    @And("I add extra option to the {int} question")
    public void iAddExtraOptionToTheQuestion(int qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//span[contains(text(),'Add Option')]/.."))
    }

    @And("I type {string} as option number {int} into question number {int}")
    public void iTypeAsOptionNumberIntoQuestionNumber(String optionValue, int optionNum, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+optionNum+"*']")).sendKeys(optionValue);
    }

    @Then("I type {string} into title of the {int} question")
    public void iTypeIntoTitleOfTheQuestion(String questionValue, int qestionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qestionNum+"')]/../../..//textarea[@placeholder='Question *']")).sendKeys(questionValue);
    }

    @Then("I select option number {int} as the correct option of the {int} question")
    public void iSelectOptionNumberAsTheCorrectOptionOfTheQuestion(int optionNum, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+optionNum+"*']/../../../../../mat-radio-button")).click();
    }
}


