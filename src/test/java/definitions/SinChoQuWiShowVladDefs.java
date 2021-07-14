package definitions;

//This steps definition was made by Vladimir Borisov for singleChoiseQuestionWithShowstopperVlad feature

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class SinChoQuWiShowVladDefs {
    @Then("I click {string} checkbox in {string} question")
    public void iClickCheckboxInQuestion(String checkBox, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//span[contains(text(),'" + checkBox + "')]/../..//input/..")).click();
    }

    @And("I select {string} question type in question number {string}")
    public void iSelectQuestionTypeInQuestionNumber(String questionType, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//div[contains(text(),'" + questionType + "')]")).click();
    }

    @Then("I move question number {string} {string}")
    public void iMoveQuestionNumber(String questionNum, String upDownButton) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//span[contains(text(),'Move Question " + upDownButton + "')]/..")).click();

    }

    @And("I add extra option to the {string} question")
    public void iAddExtraOptionToTheQuestion(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//span[contains(text(),'Add Option')]/..")).click();
    }

    @And("I type {string} as option number {string} into question number {string}")
    public void iTypeAsOptionNumberIntoQuestionNumber(String optionValue, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//textarea[@placeholder='Option " + optionNum + "*']")).sendKeys(optionValue);
    }

    @Then("I type {string} into title of the {string} question")
    public void iTypeIntoTitleOfTheQuestion(String questionValue, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//textarea[contains(@placeholder,'Question')]")).sendKeys(questionValue);
    }

    @Then("I select option number {string} as the correct option of the {string} question of {string} type")
    public void iSelectOptionNumberAsTheCorrectOptionOfTheQuestionOfType(String optionNum, String questionNum, String questionType) {
        switch (questionType) {
            case "Single": {
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//textarea[@placeholder='Option " + optionNum + "*']/../../../../../mat-radio-button")).click();
                break;
            }
            case "Multiple": {
                getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/../../..//textarea[@placeholder='Option " + optionNum + "*']/../../../../..//input/..")).click();
                break;
            }
            default: {
                System.out.println("Please select Single or Multiple type of question");
            }
        }
    }

    @And("I verify {string} checkbox of the {string} question is checked off")
    public void iVerifyCheckboxOfTheQuestionIsCheckedOff(String checkBox, String questionNum) {
//        Draft code
//        String temp;
//        temp = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input/..")).getAttribute("aria-label aria-checked");
//        assertThat(temp="true").isTrue();
//        System.out.println(temp);
    }

    @Then("I switch to {string} question")
    public void iSwitchToQuestion(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + questionNum + "')]/..")).click();
    }


    @Then("I verify {string} of {string} question of {string} quiz is Show-Stopper")
    public void iVerifyOfQuestionOfQuizIsShowstopper(String questionNum, String questionTotal, String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[text()='Preview']")).click();
        String Label = "Show-Stopper Question";
        System.out.println(Label);
        Thread.sleep(2000);
        String actualLabel = getDriver().findElement(By.xpath("//h5[contains(text(),'Question " + questionNum + " / " + questionTotal + "')]/../p[contains(@class,'show-stopper')]")).getText();
        assertThat(actualLabel.contains(Label)).isTrue();
    }
}
