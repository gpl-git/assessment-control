package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MCQAndreiStepDefs {



    @And("I add quiz question")
    public void iAddQuizQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();


    }

    @When("I click {string} question type")
    public void iClickQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I check {string} as correct  in question {string}")
    public void iCheckAsCorrectInQuestion(String option, String questionN) {
        String xpath = "//mat-panel-title[contains(text(),'" + questionN + "')]/../../../..//*[@placeholder='" + option + "']/../../../../..//*[input]";
        getDriver().findElement(By.xpath(xpath)).click();
    }


    @And("I click  Include other option")
    public void iClickIncludeOtherOption() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Other')]")).click();
    }


    @And("I preview quiz {string}")
    public void iPreviewQuiz(String title) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'00 Galina Demo Quiz')]/../../..//span[contains(text(),'Preview')]")).click();
//        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
//        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);

}

    @And("The option  {string} will be displayed")
    public void theOptionWillBeDisplayed(String text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Other']"));
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Other']")).isDisplayed()).isTrue();
    }

    @And("I close quiz")
    public void iCloseQuiz() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();

    }

    @And("I delete quiz title {string}")
    public void iDeleteQuizTitle(String title) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+title+"')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
    }
}



//
//    @Then("I check checkbox {string} as correct answer in question {string}")
//    public void iCheckCheckboxAsCorrectAnswerInQuestion(String questionNum, String optionNum) {
////        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='"+optionNum+"']/../../../../..//div[input]")).click();
//
//
//        String xpath = "//mat-panel-title[contains(text(),'" + questionNum + "')]/../../../..//*[@placeholder='" + optionNum + "']/../../../../..//*[input]";
//        getDriver().findElement(By.xpath(xpath)).click();
//    }











